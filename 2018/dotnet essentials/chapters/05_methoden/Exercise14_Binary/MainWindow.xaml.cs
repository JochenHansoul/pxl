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

namespace Exercise14_Binary
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
