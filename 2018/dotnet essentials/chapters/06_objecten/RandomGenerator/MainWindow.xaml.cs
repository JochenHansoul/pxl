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

namespace RandomGenerator
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private DispatcherTimer timer = new DispatcherTimer();
        Random random = new Random();

        public MainWindow()
        {
            InitializeComponent();
            timer.Interval = TimeSpan.FromSeconds(0.5);
            timer.Start();
            timer.Tick += AddRandomNumber;
            stopButton.Click += StopAddingNumber;
        }

        private void AddRandomNumber(Object sender, EventArgs e)
        {
            randomLabel.Content += random.Next(10) + " ";
        }

        private void StopAddingNumber(Object sender, EventArgs e)
        {
            timer.Stop();
        }
    }
}
