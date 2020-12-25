using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Exercise6_calculating
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public MainWindow()
        {
            InitializeComponent();
        }

        private void ClickButton_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                string calculation = inputTextBox.Text;
                StringCalculation(calculation);
            }
            catch (Exception exceptionObject)
            {
                MessageBox.Show(Convert.ToString(exceptionObject));
            }
        }

        private void StringCalculation(string inputString)
        {
            int positionSymbol = 0;
            char symbol = '+';
            if (!inputString.Contains('+') && !inputString.Contains('-')) throw new Exception(inputString + " does not contain '+' or '-'");
            if (inputString.Contains('+') && !inputString.Contains('-'))
            {
                positionSymbol = inputString.IndexOf("+");
                if (inputString.IndexOf('+', positionSymbol + 1) != -1) throw new Exception(inputString + " may only contain one '+'");
            }
            else if (inputString.Contains('-') && !inputString.Contains('+'))
            {
                positionSymbol = inputString.IndexOf("-");
                if (inputString.IndexOf('-', positionSymbol + 1) != -1) throw new Exception(inputString + " may only contain one '-'");
                symbol = '-';
            }
            else
            {
                throw new Exception(inputString + " cannot contain both '+' and '-'");
            }
            string[] numbers = inputString.Split(symbol);
            string firstBit = numbers[0], lastBit = numbers[1];
            if (!(firstBit.IndexOf(' ') == firstBit.Length - 1 && lastBit.IndexOf(' ') == 0 && lastBit.IndexOf(' ', 1) == -1))
            {
                throw new Exception("Spaces error");
            }
            firstBit = firstBit.Trim();
            lastBit = lastBit.Trim();
            if (symbol == '+')
            {
                outputLabel.Content = Convert.ToString(Convert.ToInt32(firstBit) + Convert.ToInt32(lastBit));
            }
            else
            {
                outputLabel.Content = Convert.ToString(Convert.ToInt32(firstBit) - Convert.ToInt32(lastBit));
            }
        }
    }
}
