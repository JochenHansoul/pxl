using System;
using System.Windows;

namespace Exercise14
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private string ConvertNumberToBinary(int number)
        {
            String binary = Convert.ToString(number, 2);
            return binary;
        }

        private void CalculateButton_Click(object sender, RoutedEventArgs e)
        {
            int number = Convert.ToInt32(intigerTextBox.Text);
            string result = ConvertNumberToBinary(number);
            binaryTextBlock.Text = result;
        }
    }
}
