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

namespace Exercise04
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            SolidColorBrush brush = new SolidColorBrush(Colors.Black);
            DrawStaircase(6, paperCanvas, brush);
        }

        private void DrawRectangle(Canvas drawingArea, SolidColorBrush brushToUse, double x, double y, double width, double height)
        {
            var rectangle = new Rectangle()
            {
                Stroke = brushToUse,
                StrokeThickness = 1,
                Margin = new Thickness(x, y, 0, 0),
                Width = width,
                Height = height
            };
            drawingArea.Children.Add(rectangle);
        }

        private void DrawStaircase(int stairs, Canvas drawingArea, SolidColorBrush brushToUse)
        {
            drawingArea.Children.Clear();
            int y = 20;
            for (int i = 1; i <= stairs; i++)
            {
                int x = 20;
                for (int j = 0; j < i; j++)
                {
                    DrawRectangle(drawingArea, brushToUse, x, y, 20, 20);
                    x += 30;
                }
                y += 30;
            }
        }
    }
}
