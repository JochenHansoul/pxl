using System;
using System.Windows;
using System.Windows.Threading;

namespace Exercise10
{
    public partial class MainWindow : Window
    {
        private DispatcherTimer timer = new DispatcherTimer();
        private double interval = 0.2;

        public MainWindow()
        {
            InitializeComponent();
            timer.Interval = TimeSpan.FromSeconds(interval);
            timerProgressBar.Minimum = 0;
            timerProgressBar.Maximum = 5;
            timerProgressBar.Value = 0;
            timer.Tick += timer_Tick;
            timer.Start();
        }

        private void timer_Tick(object senter, EventArgs e)
        {
            timerProgressBar.Value += interval;
            if (timerProgressBar.Value >= 5)
            {
                timer.Stop();
                okButton.IsEnabled = false;
                MessageBox.Show("U hebt maar 5 seconden om in te loggen");
            }
        }

        private void CancelButton_Click(object sender, RoutedEventArgs e)
        {
            timer.Stop();
        }

        private void OkButton_Click(object sender, RoutedEventArgs e)
        {
            if (nameTextBox.Text == "jochen" && enterPasswordBox.Password == "hansoul")
            {
                timer.Stop();
                MessageBox.Show("U bent correct ingelogd");
            }
        }
    }
}
