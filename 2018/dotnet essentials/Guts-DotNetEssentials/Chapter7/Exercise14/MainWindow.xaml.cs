using System;
using System.Windows;

namespace Exercise14
{
    public partial class MainWindow : Window
    {
        private double amount = 1000;
        public MainWindow()
        {
            InitializeComponent();
        }

        private void CalculateButton_Click(object sender, RoutedEventArgs e)
        {
            amount *= ((bool)maleRadioButton.IsChecked) ? 1.5 : 1.25;
            if ((bool)age18.IsChecked)
            {
                amount *= 2;
            }
            else if ((bool)age30.IsChecked)
            {
                amount *= 1.8;
            }
            else if ((bool)age45.IsChecked)
            {
                amount *= 1.6;
            }
            else
            {
                amount *= 1.5;
            }
            MessageBox.Show(Convert.ToString(amount));
        }
    }
}
