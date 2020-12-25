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

namespace Exercise13_FormBTW
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

        private void CalculateBtwAndTotal(double netto, out double btw, out double total)
        {
            btw = (lowRateCheckBox.IsChecked.HasValue && lowRateCheckBox.IsChecked.Value) ? netto * 0.06 : netto * 0.21;
            total = netto + btw;
        }

        private void CalculateButton_Click(object sender, RoutedEventArgs e)
        {
            double netto = Convert.ToDouble(nettoTextBox.Text);
            CalculateBtwAndTotal(netto, out double btw, out double total);
            btwTextBlock.Text = Convert.ToString(btw);
            totalTextBlock.Text = Convert.ToString(total);
        }
    }
}
