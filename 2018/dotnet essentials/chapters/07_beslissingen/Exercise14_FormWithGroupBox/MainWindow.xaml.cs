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

namespace Exercise14_FormWithGroupBox
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private double baseRate = 1000;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void CalculateRateButton_Click(object sender, RoutedEventArgs e)
        {
            double rate;
            string errorMessage = "";

            rate = ((bool)maleRadioButton.IsChecked) ? baseRate * 1.5 : baseRate * 1.25;

            if ((bool) maleRadioButton.IsChecked)
            {
                rate = baseRate * 1.5;
            }
            else if ((bool) femaleRadioButton.IsChecked)
            {
                rate = baseRate * 1.25;
            }
            else
            {
                errorMessage += "No gender selected\n";
            }

            // age (18+)
            if ((bool) age18.IsChecked)
            {
                rate *= 2;
            }
            else if ((bool) age30.IsChecked)
            {
                rate *= 1.8;
            }
            else if ((bool) age45.IsChecked)
            {
                rate *= 1.6;
            }
            else if ((bool) age60.IsChecked)
            {
                rate *= 1.5;
            }
            else
            {
                errorMessage += "No age selected";
            }

            // show rate or error
            if (errorMessage == "")
            {
                MessageBox.Show(Convert.ToString(rate));
            }
            else
            {
                MessageBox.Show(errorMessage);
            }
        }
    }
}
