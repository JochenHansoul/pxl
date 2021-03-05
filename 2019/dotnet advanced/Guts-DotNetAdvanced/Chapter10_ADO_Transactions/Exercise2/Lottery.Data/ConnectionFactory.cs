using System.Configuration;
using System.Data.SqlClient;
using Lottery.Data.Interfaces;

namespace Lottery.Data
{
    public class ConnectionFactory : IConnectionFactory
    {
        [System.Obsolete]
        public SqlConnection CreateSqlConnection()
        {
            string connectionString = ConfigurationManager.ConnectionStrings["LotteryConnection"].ConnectionString;
            /*string connectionString2 =
                @"Data Source=(localdb)\MSSQLLocalDB;" +
                "Initial Catalog=Lottery_ADO_Test;" +
                "Integrated Security=True";*/
            return new SqlConnection(connectionString);
        }
    }
}
