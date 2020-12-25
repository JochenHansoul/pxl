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

namespace Exercise02_CircleAndGlobe
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

        private void CircleButton_Click(object sender, RoutedEventArgs e)
        {
            calculatingTextBlock.Visibility = Visibility.Visible;
            // zij doet dit met labels
            double radius = Convert.ToDouble(inputTextBox.Text);
            calculatingTextBlock.Text = $"{2 * radius * Math.PI:0.00} omtrek cirkel\n{Math.PI * Math.Pow(radius, 2):0.00} oppervlakte Cirkel";
        }

        private void BolButton_Click(object sender, RoutedEventArgs e)
        {
            calculatingTextBlock.Visibility = Visibility.Visible;
            double radius = Convert.ToDouble(inputTextBox.Text);
            calculatingTextBlock.Text = $"{4 * Math.PI * Math.Pow(radius, 2):0.00} oppervlakte bol\n{4.0 / 3.0 * Math.PI * Math.Pow(radius, 3):0.00} volume bol";
        }
    }
}
