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

namespace SliderOefening
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Ellipse ellipse;

        public MainWindow()
        {
            InitializeComponent();

            horizontalSlider.Minimum = 0;
            horizontalSlider.Maximum = paperCanvas.Width;

            verticalSlider.Minimum = 0;
            verticalSlider.Maximum = paperCanvas.Height;

            horizontalLabel.Content = Convert.ToString(horizontalSlider.Value);
            verticalLabel.Content = Convert.ToString(verticalSlider.Value);

            drawEllipse();
        }

        public void drawEllipse()
        {
            ellipse = new Ellipse();
            ellipse.Width = horizontalSlider.Value;
            ellipse.Height = verticalSlider.Value;
            ellipse.StrokeThickness = 1;
            ellipse.Stroke = new SolidColorBrush(Colors.BlueViolet);
            ellipse.Fill = new SolidColorBrush(Colors.BlueViolet);
            paperCanvas.Children.Add(ellipse);
        }

        private void HorizontalSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            int horizontal = Convert.ToInt32(horizontalSlider.Value);
            horizontalLabel.Content = Convert.ToString(horizontal);
            UpdateEllipse();
        }


        private void VerticalSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            UpdateEllipse();
        }

        private void UpdateEllipse()
        {
            ellipse.Width = horizontalSlider.Value;
            ellipse.Height = verticalSlider.Value;
        }

    }
}
