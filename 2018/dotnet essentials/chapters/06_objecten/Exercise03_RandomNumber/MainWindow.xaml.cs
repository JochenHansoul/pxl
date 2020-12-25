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

namespace Exercise03_RandomNumber
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Random random = new Random();
        private int randomNumber = 0;
        private int sum = 0;
        private int average = 0;
        private int counter = 1;

        public MainWindow()
        {
            InitializeComponent();
            //randomTextBox.IsEnabled = false;
            //sumTextBox.IsEnabled = false;
            //averageTextBox.IsEnabled = false;
        }

        private void RandomButton_Click(object sender, RoutedEventArgs e)
        {
            randomNumber = random.Next(200, 401);
            randomLabel.Content = Convert.ToString(randomNumber);
            sum += randomNumber;
            sumLabel.Content = Convert.ToString(sum);
            average = sum / counter;
            averageLabel.Content = Convert.ToString(average);
            counter++;
        }
    }
}
