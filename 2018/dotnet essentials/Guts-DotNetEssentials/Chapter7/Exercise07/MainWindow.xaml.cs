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

namespace Exercise07
{
    public partial class MainWindow : Window
    {

        private int totalValue = 0;
        private string operatorUsed = "+";

        public MainWindow()
        {
            InitializeComponent();
        }

        private void DigitButton_Click(object sender, RoutedEventArgs e)
        {
            if (Convert.ToString(displayTextBlock.Text) == "0")
            {
                displayTextBlock.Text = Convert.ToString(((Button)sender).Content);
            }
            else
            {
                displayTextBlock.Text = displayTextBlock.Text + "" + ((Button)sender).Content;
            }
        }

        private void OperatorButton_Click(object sender, RoutedEventArgs e)
        {
            switch (operatorUsed)
            {
                case "+":
                    totalValue += Convert.ToInt32(displayTextBlock.Text);
                    displayTextBlock.Text = "";
                    break;
                case "-":
                    totalValue -= Convert.ToInt32(displayTextBlock.Text);
                    displayTextBlock.Text = "";
                    break;
            }
            operatorUsed = Convert.ToString(((Button)sender).Content);
            if (operatorUsed == "=")
            {
                displayTextBlock.Text = Convert.ToString(totalValue);
                operatorUsed = "+";
                totalValue = 0;
            }
        }

        private void ClearButton_Click(object sender, RoutedEventArgs e)
        {
            displayTextBlock.Text = "0";
            operatorUsed = "+";
            totalValue = 0;
        }
    }
}
