using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;

namespace SliderOefening2
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

        private void drawEllipse()
        {
            ellipse = new Ellipse();
            ellipse.Width = horizontalSlider.Value;
            ellipse.Height = verticalSlider.Value;
            ellipse.StrokeThickness = 1;
            ellipse.Stroke = new SolidColorBrush(Colors.AntiqueWhite);
            ellipse.Fill = new SolidColorBrush(Colors.AntiqueWhite);
            ellipse.Margin = new Thickness(0, 0, 0, 0);
            paperCanvas.Children.Add(ellipse);
        }

        private void HorizontalSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            ellipse.Width = horizontalSlider.Value;
            horizontalLabel.Content = Convert.ToString(horizontalSlider.Value);
        }

        private void VerticalSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            ellipse.Height = verticalSlider.Value;
            verticalLabel.Content = Convert.ToString(verticalSlider.Value);
        }
    }
}
