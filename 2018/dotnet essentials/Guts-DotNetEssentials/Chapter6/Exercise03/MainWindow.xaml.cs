using System;
using System.Windows;

namespace Exercise03
{
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
            randomTextBox.IsEnabled = false;
            sumTextBox.IsEnabled = false;
            averageTextBox.IsEnabled = false;
        }

        private void RandomButton_Click(object sender, RoutedEventArgs e)
        {
            randomNumber = random.Next(200, 401);
            randomTextBox.Text = Convert.ToString(randomNumber);
            sum += randomNumber;
            sumTextBox.Text = Convert.ToString(sum);
            average = sum / counter;
            averageTextBox.Text = Convert.ToString(average);
            counter++;
        }
    }
}
