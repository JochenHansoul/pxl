using System.Configuration;
using System.Data.SqlClient;

namespace Payables.Data
{
    internal static class ConnectionFactory
    {
        public static SqlConnection CreateSqlConnection()
        {
            //string connectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=Payables;Integrated Security=True";
            string connectionString =
                ConfigurationManager.ConnectionStrings["PayablesConnectionString"].ConnectionString;
            SqlConnection connection = new SqlConnection(connectionString);
            return connection;
        }
    }
}
