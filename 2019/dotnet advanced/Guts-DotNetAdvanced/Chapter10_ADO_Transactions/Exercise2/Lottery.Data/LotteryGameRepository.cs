using System.Collections.Generic;
using System.Data.SqlClient;
using Lottery.Data.Interfaces;
using Lottery.Domain;

namespace Lottery.Data
{
    public class LotteryGameRepository : ILotteryGameRepository
    {
        private IConnectionFactory _factory;

        public LotteryGameRepository(IConnectionFactory connectionFactory)
        {
            _factory = connectionFactory;
        }

        public IList<LotteryGame> GetAll()
        {
            SqlConnection connection = null;
            IList<LotteryGame> allLotteryGames = null;
            try
            {
                connection = _factory.CreateSqlConnection();
                allLotteryGames = new List<LotteryGame>();
                string selectAllGames =
                    "SELECT * " +
                    "FROM LotteryGames";
                SqlCommand selectCommand = new SqlCommand(selectAllGames, connection);
                connection.Open();
                SqlDataReader reader = selectCommand.ExecuteReader(System.Data.CommandBehavior.CloseConnection);
                int idOrdinal = reader.GetOrdinal("Id");
                int nameOrdinal = reader.GetOrdinal("Name");
                int numberOfNumbersInADrawOrdinal = reader.GetOrdinal("NumberOfNumbersInADraw");
                int maximumNumberOrdinal = reader.GetOrdinal("MaximumNumber");
                while (reader.Read())
                {
                    allLotteryGames.Add(new LotteryGame
                    {
                        Id = reader.GetInt32(idOrdinal),
                        Name = reader.GetString(nameOrdinal),
                        NumberOfNumbersInADraw = reader.GetInt32(numberOfNumbersInADrawOrdinal),
                        MaximumNumber = reader.GetInt32(maximumNumberOrdinal)
                    });
                }
            }
            finally
            {
                connection?.Close();
            }
            return allLotteryGames;
        }
    }
}