using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MusicStore.Data
{
    public class GenreRepository
    {
        public static IList<Genre> GetGenres()
        {
            SqlConnection connection = null;
            IList<Genre> genres = new List<Genre>();
            string selectString =
                "SELECT * " +
                "FROM Genre";
            try
            {
                connection = ConnectionFactory.CreateSqlConnection();
                SqlCommand selectCommand = new SqlCommand(selectString, connection);
                SqlDataReader reader = selectCommand.ExecuteReader();
                int genreIdOrdinal = reader.GetOrdinal("GenreId");
                int nameOrdinal = reader.GetOrdinal("Name");
                int descriptionOrdinal = reader.GetOrdinal("Description");
                connection.Open(); //moet connection openen?
                while(reader.Read())
                {
                    genres.Add(new Genre
                    {
                        GenreId = reader.GetInt32(genreIdOrdinal),
                        Name = reader.GetString(nameOrdinal),
                        Description = reader.GetString(descriptionOrdinal)
                    });
                }
            }
            finally
            {
                connection?.Close();
            }
            return genres;
        }
    }
}
