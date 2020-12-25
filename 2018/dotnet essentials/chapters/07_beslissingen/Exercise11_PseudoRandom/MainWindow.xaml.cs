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
using System.Windows.Threading;

namespace Exercise11_PseudoRandom
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Random randomGenerator1;
        Random randomGenerator2;

        public MainWindow()
        {
            InitializeComponent();
            randomGenerator1 = new Random();
            randomGenerator2 = new Random(5575);
        }

        private void FirstButton_Click(object sender, RoutedEventArgs e)
        {
            int number = randomGenerator1.Next(5000);
            firstLabel.Content = Convert.ToString(number);
        }

        private void SecondButton_Click(object sender, RoutedEventArgs e)
        {
            int number = randomGenerator2.Next(5000);
            secondLabel.Content = Convert.ToString(number);
        }
    }
}
