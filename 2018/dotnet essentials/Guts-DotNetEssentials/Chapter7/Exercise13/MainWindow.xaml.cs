using System;
using System.Windows;

namespace Exercise13
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            btwTextBox.IsEnabled = false;
            totalTextBox.IsEnabled = false;
        }

        private void CalculateBtwAndTotal(double netto, out double btw, out double total)
        {
            btw = (lowRateCheckBox.IsChecked.HasValue && lowRateCheckBox.IsChecked.Value) ? netto * 0.06 : netto * 0.21;
            total = netto + btw;
        }

        private void CalculateButton_Click(object sender, RoutedEventArgs e)
        {
            double netto = Convert.ToDouble(priceTextBox.Text);
            CalculateBtwAndTotal(netto, out double btw, out double total);
            btwTextBox.Text = Convert.ToString(btw);
            totalTextBox.Text = Convert.ToString(total);
        }
    }
}
