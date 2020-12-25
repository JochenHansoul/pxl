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

namespace alarmClock
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Color _white;
        private Color _red;
        private SolidColorBrush _colorBrush;
        
        private AlarmClock _alarmClock;

        private DispatcherTimer _clockTimer;
        private DispatcherTimer _alarmTimer;

        public MainWindow()
        {
            InitializeComponent();

            _white = Colors.White;
            _red = Colors.Tomato;
            _colorBrush = new SolidColorBrush(_white);
            clockLabel.Background = _colorBrush;

            _alarmClock = new AlarmClock();

            _clockTimer = new DispatcherTimer();
            _clockTimer.Interval = TimeSpan.FromSeconds(1);
            _clockTimer.Tick += _clockTimer_Tick;
            
            _alarmTimer = new DispatcherTimer();
            _alarmTimer.Interval = TimeSpan.FromMilliseconds(300);
            _alarmTimer.Tick += _alarmTimer_Tick;
            _clockTimer.Start();
        }

        private void SetButton_Click(object sender, RoutedEventArgs e)
        {
            _alarmClock.AlarmTime = alarmTimeTextBox.Text;
        }

        private void _clockTimer_Tick(object sender, EventArgs e)
        {
            clockLabel.Content = _alarmClock.CurrentTime;

            if (_alarmClock.isAlarmPassed())
            {
                Console.WriteLine("Alarm passed");
                _alarmTimer.Start();
            }
            else
            {
                Console.WriteLine("Alarm NOT passed");
            }
            
            if (_alarmClock.ShouldStopBeeping())
            {
                Console.WriteLine("ShouldStop");
                _alarmTimer.Stop();
                _colorBrush.Color = _white;
                _alarmClock.Reset();
                alarmTimeTextBox.Clear();
            }
        }

        private void _alarmTimer_Tick(object sender, EventArgs e)
        {
            System.Media.SystemSounds.Beep.Play();
            _colorBrush.Color = _colorBrush.Color == _white ? _red : _white;
        }
    }
}

