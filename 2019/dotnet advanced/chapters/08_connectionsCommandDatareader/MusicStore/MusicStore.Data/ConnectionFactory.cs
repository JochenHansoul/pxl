using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MusicStore.Data
{
    public class ConnectionFactory
    {
        public static SqlConnection CreateSqlConnection()
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MusicStoreConnection"].ConnectionString;
            return new SqlConnection(connectionString);
        }
    }
}
