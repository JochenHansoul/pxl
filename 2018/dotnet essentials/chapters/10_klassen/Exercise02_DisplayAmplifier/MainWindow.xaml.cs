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

namespace Exercise02_DisplayAmplifier
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Amplifier amplifier;

        public MainWindow()
        {
            InitializeComponent();

            amplifier = new Amplifier(0, 10);
            displaySlider.Minimum = amplifier.MinimumValue;
            displaySlider.Maximum = amplifier.MaximumValue;
            minimumLabel.Content = displaySlider.Minimum;
            maximumLabel.Content = displaySlider.Maximum;
            valueLabel.Content = amplifier.GetNewValue();
        }

        private void DisplaySlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            valueLabel.Content = amplifier.GetNewValue();
        }
    }
}
