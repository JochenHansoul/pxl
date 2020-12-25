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
using System.Media;

namespace Exercise08_AlarmClock
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private DispatcherTimer _clockTimer = new DispatcherTimer();
        private DispatcherTimer _alarmTimer = new DispatcherTimer();

        private AlarmClock _alarmClock;

        private Color _white;
        private Color _red;
        private SolidColorBrush _brush;

        public MainWindow()
        {
            InitializeComponent();


            _alarmClock = new AlarmClock(DateTime.Now.AddSeconds(5));

            _white = Colors.White;
            _red = Colors.Tomato;
            _brush = new SolidColorBrush(_white);

            clockTextBlock.Text = _alarmClock.CurrentTime;
            clockTextBlock.Background = _brush;


            _alarmTimer.Interval = TimeSpan.FromSeconds(0.3);
            _alarmTimer.Tick += AlarmTimer_Tick;

            _clockTimer.Interval = TimeSpan.FromSeconds(1);
            _clockTimer.Tick += clockTimer_Tick;
            _clockTimer.Start();
        }

        private void clockTimer_Tick(object sender, EventArgs e)
        {
            clockTextBlock.Text = _alarmClock.CurrentTime;
            ActivateOrStopAlarm(_alarmClock);
        }

        private void ActivateOrStopAlarm(AlarmClock usedAlarm)
        {
            if (usedAlarm.IsAlarmPassed() && !usedAlarm.ShouldStopBeeping())
            {
                _alarmTimer.Start();
                SystemSounds.Beep.Play();
                Console.WriteLine("alarm is passed");
            }
            else
            {
                _alarmTimer.Stop();
                _brush.Color = _white;
                Console.WriteLine("Alarlm is NOT passed");
            }
        }

        private void AlarmTimer_Tick(object sender, EventArgs e)
        {
            _brush.Color = _brush.Color == _white ? _red : _white;
        }

        private void AlarmButton_Click(object sender, RoutedEventArgs e)
        {
            _alarmClock.AlarmTime = alarmTextBox.Text;
        }

        private void ResetButton_Click(object sender, RoutedEventArgs e)
        {
            _alarmClock.Reset();
            _brush.Color = _white;
            clockTextBlock.Background = _brush;
        }
    }
}
