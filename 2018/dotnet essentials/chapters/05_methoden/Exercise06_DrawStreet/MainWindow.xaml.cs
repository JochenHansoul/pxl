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

namespace Exercise06_DrawStreet
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            SolidColorBrush black = new SolidColorBrush(Colors.Black);
            DrawHouse(paperCanvas, black, 50, 50, 50, 50);
        }

        private void DrawHouse(Canvas drawingArea, SolidColorBrush brushToUse, double xPlace, double yPlace, double width, double height)
        {
            SolidColorBrush brush = new SolidColorBrush(Colors.Black);

            DrawLogo(drawingArea, brushToUse, 20, 100);
            DrawLogo(drawingArea, brushToUse, 80, 100);
            DrawTriangle2(drawingArea, brushToUse, 80, 60, 60, 40);
            DrawTriangle2(drawingArea, brushToUse, 80, 60, -60, 40);
        }

        private void DrawTriangle2(Canvas drawingArea,
                                   SolidColorBrush brushToUse,
                                   double xPlace,
                                   double yPlace,
                                   double width,
                                   double height)
        {
            System.Windows.Point point1 = new Point(xPlace, yPlace);
            System.Windows.Point point2 = new Point(xPlace, yPlace + height);
            System.Windows.Point point3 = new Point(xPlace + width, yPlace + height);
            PointCollection pointCollection = new PointCollection();
            pointCollection.Add(point1);
            pointCollection.Add(point2);
            pointCollection.Add(point3);

            var triangle = new Polygon()
            {
                Points = pointCollection,
                Stroke = brushToUse,
                StrokeThickness = 1
            };

            drawingArea.Children.Add(triangle);
        }

        private void DrawLogo(Canvas drawingArea,
                                  SolidColorBrush brushToUse,
                                  double xPos,
                                  double yPos)
        {
            DrawRectangle(drawingArea, brushToUse, xPos, yPos, 20);
            DrawRectangle(drawingArea, brushToUse, xPos, yPos, 40);
            DrawRectangle(drawingArea, brushToUse, xPos, yPos, 60);
        }

        private void DrawRectangle(Canvas drawingArea,
                                   SolidColorBrush brushToUse,
                                   double xPos,
                                   double yPos,
                                   double size)
        {
            Rectangle rectangle = new Rectangle
            {
                Width = size,
                Height = size,
                Margin = new Thickness(xPos, yPos, 0, 0),
                Stroke = brushToUse
            };
            drawingArea.Children.Add(rectangle);
        }
    }
}
