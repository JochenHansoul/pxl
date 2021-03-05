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
            calculateTableTextBox.Clear();
            int repeat = 5;
            int number = Convert.ToInt32(numberTextBox.Text);

            for (int i = 1; i <= number; i++)
            {
                calculateTableTextBox.AppendText($"\t{i}");
            }
            calculateTableTextBox.AppendText(Environment.NewLine);
            calculateTableTextBox.AppendText(Environment.NewLine);

            for (int i = 1; i <= repeat; i++)
            {
                calculateTableTextBox.AppendText(Convert.ToString(i));
                for (int j = 1; j <= number; j++)
                {
                    calculateTableTextBox.AppendText($"\t{j * i}");
                }
                calculateTableTextBox.AppendText(Environment.NewLine);
            }
        }
    }
}
