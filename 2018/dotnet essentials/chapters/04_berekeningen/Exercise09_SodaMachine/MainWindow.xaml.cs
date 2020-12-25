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

namespace Exercise09_SodaMachine
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

        private void CalculateButton_Click(object sender, RoutedEventArgs e)
        {
            int amountGiven = Convert.ToInt32(amountGivenTextBox.Text);
            int itemCost = Convert.ToInt32(itemCostTextBox.Text);
            if (itemCost <= amountGiven) {
                int returnMoney = amountGiven - itemCost;
                int euro1 = returnMoney / 100;
                returnMoney %= 100;
                int cent50 = returnMoney / 50;
                returnMoney %= 50;
                int cent20 = returnMoney / 20;
                returnMoney %= 20;
                int cent10 = returnMoney / 10;
                returnMoney %= 10;
                int cent5 = returnMoney / 5;
                returnMoney %= 5;
                int cent2 = returnMoney / 2;
                returnMoney %= 2;
                resultlabel.Content =
                    $"Number of 1 euro coins is {euro1}\n" +
                    $"Number of 50 cent coins is {cent50}\n" +
                    $"Number of 20 cent coins is {cent20}\n" +
                    $"Number of 10 cent coins is {cent10}\n" +
                    $"Number of 5 cent coins is {cent5}\n" +
                    $"Number of 2 cent coins is {cent2}\n" +
                    $"Number of 1 cent coins is {returnMoney}\n";
            } else
            {
                resultlabel.Content = "U hebt te weinig geld ingegeven";
            }
        }

    }
}
