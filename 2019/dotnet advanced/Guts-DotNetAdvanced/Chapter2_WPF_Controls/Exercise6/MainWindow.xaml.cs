using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Input;

namespace Exercise6
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void NumberButtonClick(object sender, RoutedEventArgs e)
        {
            if (e.Source is ButtonBase)
            {
                numberTextBox.Text += (e.Source as ButtonBase).Content.ToString();
            }
            //e.Handled = true;
        }

        private void numberTextBox_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            foreach(Char character in e.Text) //zet string om in karakters
            {
                if (!Char.IsDigit(character)) e.Handled = true;
            }
        }
    }
}
