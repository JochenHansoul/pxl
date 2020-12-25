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

namespace GroteT
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

        private void NameCanvas_Loaded(object sender, RoutedEventArgs e)
        {
            // making a T with 2 lines
            Line horizontalLine = new Line
            {
                X1 = 15,
                Y1 = 20,
                X2 = 75,
                Y2 = 20,
                Stroke = new SolidColorBrush(Colors.Cyan),
                StrokeThickness = 4 // verwacht een double
            };
            nameCanvas.Children.Add(horizontalLine);

            Line vertikalLine = new Line
            {
                X1 = 45,
                Y1 = 20,
                X2 = 45,
                Y2 = 90,
                Stroke = new SolidColorBrush(Colors.Cyan),
                StrokeThickness = 4
            };
            nameCanvas.Children.Add(vertikalLine);
        }

        private void NameButton_Click(object sender, RoutedEventArgs e)
        {
            nameRectangle.Visibility = Visibility.Visible;
        }
    }
}
