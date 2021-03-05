using System;
using System.Windows;
using System.Windows.Controls;

namespace Exercise3
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void growRepeatButton_Click(object sender, RoutedEventArgs e)
        {
            if (changeSizeRectangle.Width < paperCanvas.Width - changeSizeRectangle.Margin.Left - 10)
            {
                changeSizeRectangle.Width += 10;
            } else
            {
                changeSizeRectangle.Width = paperCanvas.Width - changeSizeRectangle.Margin.Left;
            }
        }

        private void shrinkRepeatButton_Click(object sender, RoutedEventArgs e)
        {
            if(changeSizeRectangle.Width > 10)
            {
                changeSizeRectangle.Width -= 10;
            } else
            {
                changeSizeRectangle.Width = 0;
            }
        }
    }
}
