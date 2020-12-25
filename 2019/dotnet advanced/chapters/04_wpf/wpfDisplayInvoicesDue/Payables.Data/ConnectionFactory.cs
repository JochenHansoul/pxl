using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Payables.Data
{
    class ConnectionFactory
    {
        public static SqlConnection CreateSqlConnection()
        {
            // drie manieren om dit te doen:

            //string connectionString =”Data Source = (localdb)\\MSSqlLocalDb; Initial Catalog = Payables; Integraded Security = True;“;
            //SqlConnection connection = new SqlConnection(connectionString);
            //retur connection;


            //SqlConnectionStringBuilder connBuilder = new SqlConnectionStringBuilder();
            //connBuilder.DataSource = "(localdb)\\MSSqlLocalDb";
            //connBuilder.InitialCatalog = "Payables";
            //connBuilder.IntegratedSecurity = true;

            //CreateSqlConnection conntion = new CreateSqlConnection(connBuilder.ConnectionString);
            //return connection;

            // beste manier is deze:
            string connectionString = ConfigurationManager.ConnectionStrings["PayablesConnectionString"].ConnectionString;
            CreateSqlConnection connection = new CreateSqlConnection(connectionString);
            return connection;
        }
    }
}
