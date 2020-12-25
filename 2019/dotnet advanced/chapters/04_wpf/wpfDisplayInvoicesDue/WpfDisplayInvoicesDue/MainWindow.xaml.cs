using System;
using System.Collections.Generic;
using System.Windows;

namespace WpfDisplayInvoicesDue
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            try
            {
                //TODO: retrieve invoices due from data layer
                List<Invoice> invoiceList = new List<Invoice>();
                invoiceList = InvoiceRepository.GetInvoicesDue();
                if(invoiceList.Count > 0)
                    InvoicesListView.ItemsSource = invoiceList;
                else
                {
                    MessageBox.Show("All invoices are paid in full", "No Balance Due");
                }

                //TODO: show a message box when no invoiced are due and close the application              
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, ex.GetType().ToString());
                Close();
            }
        }
    }
}
