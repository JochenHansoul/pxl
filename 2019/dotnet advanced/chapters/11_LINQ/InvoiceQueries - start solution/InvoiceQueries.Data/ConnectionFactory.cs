using System.Configuration;
using System.Data.SqlClient;

namespace InvoiceQueries.Data
{
    internal static class ConnectionFactory
    {
        public static SqlConnection CreatePayablesConnection()
        {
            string connectionString = ConfigurationManager.ConnectionStrings["PayablesConnectionString"].ConnectionString;
            SqlConnection connection = new SqlConnection(connectionString);
            return connection;
        }
    }
}
