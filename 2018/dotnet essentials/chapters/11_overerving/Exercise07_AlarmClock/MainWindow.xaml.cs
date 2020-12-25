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

namespace Exercise07_AlarmClock
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private DispatcherTimer _clockTimer = new DispatcherTimer();
        private DispatcherTimer _alarmTimer = new DispatcherTimer();

        private AlarmClock _alarmClock;

        public MainWindow()
        {
            InitializeComponent();

            _alarmTimer.Interval = TimeSpan.FromSeconds(1);
            _alarmTimer.Tick += AlarmTimer_Tick;

            _clockTimer.Interval = TimeSpan.FromSeconds(1);
            _clockTimer.Tick += clockTimer_Tick;
            _clockTimer.Start();
        }

        private void clockTimer_Tick(object sender, EventArgs e)
        {
            clockTextBlock.Text = AlarmClock.CurrentTime;
            if (_alarmClock != null)
            {
                if (_alarmClock.IsAlarmPassed())
                {
                    _alarmTimer.Start();
                    Console.WriteLine("Alarm passed");
                }
                else
                {
                    Console.WriteLine("Alarm NOT passed");
                }
                if (_alarmClock.ShouldStopBeeping())
                {
                    Console.Write("ShouldStopBeeping");
                    _alarmTimer.Stop();
                    //alarmTextBox.Clear();
                    if (_alarmClock.GetType() == typeof(FlickerAlarmClock))
                    {
                        ((FlickerAlarmClock)_alarmClock).ReturnBaseColor(clockTextBlock);
                    }
                }
            }
        }

        private void AlarmTimer_Tick(object sender, EventArgs e)
        {
            if (_alarmClock.GetType() == typeof(BeeperAlarmClock))
            {
                ((BeeperAlarmClock) _alarmClock).Beeping();
            }
            else
            {
                ((FlickerAlarmClock) _alarmClock).Flickering(clockTextBlock);
            }
        }

        private void AlarmButton_Click(object sender, RoutedEventArgs e)
        {
            if ((bool) beeperRadioButton.IsChecked)
            {
                _alarmClock = new BeeperAlarmClock();
                _alarmClock.AlarmTime = alarmTextBox.Text;
            }
            else if ((bool) flickerRadioButton.IsChecked)
            {
                _alarmClock = new FlickerAlarmClock();
                _alarmClock.AlarmTime = alarmTextBox.Text;
            }
            else
            {
                MessageBox.Show("No alarm type selected");
            }
        }

        private void ResetButton_Click(object sender, RoutedEventArgs e)
        {
            _alarmTimer.Stop();
            _alarmClock.Reset();
            if (_alarmClock.GetType() == typeof(FlickerAlarmClock))
            {
                ((FlickerAlarmClock)_alarmClock).ReturnBaseColor(clockTextBlock);
            }
        }
    }
}
