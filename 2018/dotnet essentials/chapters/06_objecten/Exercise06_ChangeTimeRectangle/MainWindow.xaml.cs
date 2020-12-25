﻿using System;
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

namespace Exercise06_ChangeTimeRectangle
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private DispatcherTimer timer = new DispatcherTimer();
        private int seconds = 0;
        private int minutes = 0;

        private Rectangle secondsRectangle = new Rectangle()
        {
            Height = 20,
            Width = 0,
            Fill = new SolidColorBrush(Colors.Blue),
            Margin = new Thickness(0, 80, 0, 0),
            MaxWidth = 600
        };

        private Rectangle minutesRectangle = new Rectangle()
        {
            Height = 20,
            Width = 0,
            Fill = new SolidColorBrush(Colors.Blue),
            Margin = new Thickness(0, 180, 0, 0),
            MaxWidth = 600
        };

        public MainWindow()
        {
            InitializeComponent();

            paperCanvas.Children.Add(secondsRectangle);
            paperCanvas.Children.Add(minutesRectangle);

            timer.Interval = TimeSpan.FromSeconds(1);
            timer.Start();
            timer.Tick += timer_Tick;
        }

        private void timer_Tick(Object sender, EventArgs e)
        {
            seconds++;
            minutes += seconds / 60;
            seconds %= 60;
            minutes %= 60;

            secondsRectangle.Width = seconds;
            minutesRectangle.Width = minutes;
        }
    }
}
