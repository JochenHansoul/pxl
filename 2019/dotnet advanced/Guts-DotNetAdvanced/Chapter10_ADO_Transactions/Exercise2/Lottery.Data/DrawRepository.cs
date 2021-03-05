using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using Lottery.Data.Interfaces;
using Lottery.Domain;

namespace Lottery.Data
{
    public class DrawRepository : IDrawRepository
    {
        private IConnectionFactory _factory;
        private int _drawId = 0;

        public DrawRepository(IConnectionFactory connectionFactory)
        {
            _factory = connectionFactory;
        }

        public IList<Draw> Find(int lotteryGameId, DateTime? fromDate, DateTime? untilDate)
        {
            SqlConnection connection = _factory.CreateSqlConnection();
            IList<Draw> selectedDraws = new List<Draw>();

            // !!!transacties gebruiken
            try
            {
                //adding games
                //creating slqcommand then adding parameters, connection and string to it
                SqlCommand selectCommand = new SqlCommand();
                //"JOIN DrawNumbers ON Draws.Id = DrawNumbers.DrawId " +
                //"GROUP BY UNIQUE Draws.Id";
                string selectAllGames =
                    "SELECT * " +
                    "FROM Draws " +
                    "JOIN DrawNumbers ON Draws.Id = DrawNumbers.DrawId " +
                    "WHERE LotteryGameId=@LotteryGameId " +
                    "ORDER BY Id";
                // checks if fromDate and untilDate is not null and ads appropriate strings and parameters
                if (fromDate != null)
                {
                    selectAllGames += " AND Date >= @MinDate";
                    selectCommand.Parameters.AddWithValue("@MinDate", fromDate);
                }
                if (untilDate != null)
                {
                    selectAllGames += " AND Date <= @MaxDate";
                    selectCommand.Parameters.AddWithValue("@MaxDate", untilDate);
                }
                selectCommand.Connection = connection;
                selectCommand.Parameters.AddWithValue("@LotteryGameId", lotteryGameId);
                selectCommand.CommandText = selectAllGames;

                connection.Open();
                SqlDataReader reader = selectCommand.ExecuteReader();
                int idOrdinal = reader.GetOrdinal("Id");
                int lotteryGameIdOrdinal = reader.GetOrdinal("LotteryGameId");
                int dateOrdinal = reader.GetOrdinal("Date");
                while (reader.Read())
                {
                    selectedDraws.Add(new Draw
                    {
                        Id = reader.GetInt32(idOrdinal),
                        LotteryGameId = reader.GetInt32(lotteryGameIdOrdinal),
                        //DrawNumbers = reader.GetValues(ICollection<DrawNumber>[] Drawnumbers),
                        Date = reader.GetDateTime(dateOrdinal)
                    });
                }

                //adding drawnumbers
                //foreach (Draw draw in selectedDraws)
                //{
                //    string selectDrawNumbers =
                //        "SELECT * " +
                //        "FROM DrawNumbers " +
                //        "WHERE DrawId=@DrawId";
                //    SqlCommand selectDrawNumbersCommand = new SqlCommand(selectDrawNumbers, connection);
                //    int id = draw.Id;
                //    selectDrawNumbersCommand.Parameters.AddWithValue("@DrawId", id);
                //    ICollection<DrawNumber> drawNumbers = new List<DrawNumber>();
                //    SqlDataReader innerReader = selectDrawNumbersCommand.ExecuteReader();
                //    int numberOrdinal = innerReader.GetOrdinal("Number");
                //    int positionOrdinal = innerReader.GetOrdinal("InnerReader");
                //    while (innerReader.Read())
                //    {
                //        drawNumbers.Add(new DrawNumber
                //        {
                //            DrawId = id,
                //            Number = reader.GetInt32(numberOrdinal),
                //            Position = reader.GetInt32(positionOrdinal)
                //        });
                //    }
                //    draw.DrawNumbers = drawNumbers;
                //}
            }
            finally
            {
                connection?.Close();
            }
            return selectedDraws;
        }

        public void Find(object id)
        {
            throw new NotImplementedException();
        }

        public void Add(int lotteryGameId, IList<int> numbers)
        {
            SqlConnection connection = _factory.CreateSqlConnection();
            try
            {
                ICollection<DrawNumber> drawNumbers = new List<DrawNumber>();
                // updaten
                /*
                string insertInDrawNumbersString =
                    "INSERT INTO DrawNumbers(DrawId, Number) " +
                    "VALUES(@DrawId, @Number)";
                foreach (int n in numbers)
                {
                    drawNumbers.Add(new DrawNumber
                    {
                        DrawId = _drawId,
                        Number = n
                    });
                    using (SqlCommand insertcommand = new SqlCommand(insertInDrawNumbersString, connection))
                    {
                        insertcommand.Parameters.AddWithValue("@DrawId", lotteryGameId);
                        insertcommand.Parameters.AddWithValue("@Number", n);
                        connection.Open();
                        insertcommand.ExecuteNonQuery();
                        connection.Close();
                    }
                }
                */
                //insert in Draws
                string insertInDrawsString =
                    "INSERT INTO Draws(LotteryGameId, DrawNumbers, Date) " +
                    "VALUES (@lotteryGameId, @DrawNumbers, @date)";
                using (SqlCommand insertcommand = new SqlCommand(insertInDrawsString, connection))
                {
                    insertcommand.Parameters.AddWithValue("@lotteryGameId", lotteryGameId);
                    insertcommand.Parameters.AddWithValue("@DrawNumbers", drawNumbers);
                    insertcommand.Parameters.AddWithValue("@date", DateTime.Now);
                    connection.Open();
                    insertcommand.ExecuteNonQuery();
                    connection.Close();
                }
                _drawId++;
            }
            finally
            {
                connection?.Close();
            }
        }
    }
}