using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfDisplayInvoicesDue
{
    public class InvoiceRepository
    {
        public static IList<Invoice> GetInvoicesDue()
        {
            List<Invoice> invoiceList = new List<Invoice>();
            SqlConnection connection = ConnectionFactory.CreateSqlConnection();

            string selectStatement = "SELECT invoiceNumber, InvoiceDate, InvoiceTotal," +
                "PaymentTotal, CreditTotal, DueDate " +
                "FROM Invoices " +
                "WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0 " +
                "ORDER BY DueDate";
            SqlCommand selectCommand = new SqlCommand();
            selectCommand.CommandText = selectStatement;
            selectCommand.Connection = connection;
            // kan ook: SqlCommand selectCommand = new SqlCommand(selectStatement,connection);

            SqlDataReader reader = null;
            try
            {
                connection.Open();
                reader = selectCommand.ExecuteReader();
                int invoiceNumberOrder = reader.GetOrdinal("InvoiceNumber"); //zo doen voor elke kolom
                int invoiceDateOrder = reader.GetOrdinal("InvoiceDate");
                int invoiceTotalOrder = reader.GetOrdinal("InvoiceTotal");
                int paymentTotalOrder = reader.GetOrdinal("PaymentTotal");
                int creditTotalOrder = reader.GetOrdinal("CreditTotal");
                int dueDateOrder = reader.GetOrdinal("DueDate");
                while(reader.Read())
                {
                    //invoice.InvoiceNumber = reader["InvoiceNumber"].ToString(); // dit is iets te gevaarlijk om telkens met een string te doen
                    Invoice invoice = new Invoice()
                    {
                        InvoiceNumber = reader.GetString(invoiceNumberOrder),
                        InvoiceDate = reader.GetDateTime(invoiceDateOrder),
                        InvoiceTotal = reader.GetDecimal(invoiceTotalOrder),
                        PaymentTotal = reader.GetDecimal(paymentTotalOrder),
                        CreditTotal = reader.GetDecimal(creditTotalOrder),
                        DueDate = reader.GetDateTime(dueDateOrder)
                    };
                    invoiceList.Add(invoice);
                }
            }
            finally
            {
                reader?.Close();
                connection?.Close();
            }
            return invoiceList;
        }
    }
}
