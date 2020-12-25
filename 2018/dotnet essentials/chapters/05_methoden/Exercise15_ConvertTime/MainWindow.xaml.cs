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

namespace Exercise15_ConvertTime
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

        private void convertButton_Click(object sender, RoutedEventArgs e)
        {
            // TODO: read input from secondsTextBox

            // TODO: convert with one method

            // TODO: show output in messagebox
            int time = Convert.ToInt32(secondsTextBox.Text);
            ConvertSecondsToHoursMinutesSeconds(time, out int hours, out int minutes, out int seconds);
            MessageBox.Show($"{hours} uur, {minutes} minuten, en {seconds} seconden.");
        }

        private void ConvertSecondsToHoursMinutesSeconds(int time, out int hours, out int minutes, out int seconds)
        {
            minutes = time / 60;
            hours = minutes / 60;
            minutes %= 60;
            seconds = time % 60 % 60;
        }
    }
}
