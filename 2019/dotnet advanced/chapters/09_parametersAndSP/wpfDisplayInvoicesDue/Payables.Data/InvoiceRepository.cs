using System.Collections.Generic;
using System.Data.SqlClient;

namespace Payables.Data
{
    public static class InvoiceRepository
    {
        public static IList<Invoice> GetInvoicesDue()
        {
            List<Invoice> invoiceList = new List<Invoice>();

            string selectStatement =
                "SELECT InvoiceNumber, InvoiceDate, InvoiceTotal, " +
                "PaymentTotal, CreditTotal, DueDate " +
                "FROM Invoices " +
                "WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0 " +
                "ORDER BY DueDate";
            
            SqlConnection connection = ConnectionFactory.CreateSqlConnection();
            SqlDataReader reader = null;
            SqlCommand selectCommand = new SqlCommand(selectStatement, connection);

            try
            {
                connection.Open();
                reader = selectCommand.ExecuteReader();
                int invoiceNumberOrdinal = reader.GetOrdinal("InvoiceNumber");
                int invoiceDateOrdinal = reader.GetOrdinal("InvoiceDate");
                int invoiceTotalOrdinal = reader.GetOrdinal("InvoiceTotal");
                int paymentTotalOrdinal = reader.GetOrdinal("PaymentTotal");
                int creditTotalOrdinal = reader.GetOrdinal("CreditTotal");
                int dueDateOrdinal = reader.GetOrdinal("DueDate");
                while (reader.Read())
                {
                    Invoice invoice = new Invoice
                    {
                        InvoiceNumber = reader.GetString(invoiceNumberOrdinal),
                        InvoiceDate = reader.GetDateTime(invoiceDateOrdinal),
                        InvoiceTotal = reader.GetDecimal(invoiceTotalOrdinal),
                        PaymentTotal = reader.GetDecimal(paymentTotalOrdinal),
                        CreditTotal = reader.GetDecimal(creditTotalOrdinal),
                        DueDate = reader.GetDateTime(dueDateOrdinal)
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
