using System;
using System.Windows;
using Payables.Data;

namespace WpfDisplayInvoicesDue
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            try
            {
                var invoices = InvoiceRepository.GetInvoicesDue();
                if (invoices.Count > 0)
                {
                    InvoicesListView.DataContext = invoices;
                }
                else
                {
                    MessageBox.Show("All invoices are paid in full.",
                        "No Balance Due");
                    Close();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, ex.GetType().ToString());
                Close();
            }
        }
    }
}
