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

namespace Opgave_3._1_driehoek
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

        private void AppearButton_Click(object sender, RoutedEventArgs e)
        {
            leftLine.Visibility = Visibility.Visible;
            rightLine.Visibility = Visibility.Visible;
            baseLine.Visibility = Visibility.Visible;
        }

        private void CreateButton_Click(object sender, RoutedEventArgs e)
        {
            SolidColorBrush colorBrush = new SolidColorBrush(Colors.DarkBlue);
            //DrawRoof(paperCanvas, colorBrush, 50, 50, 40, 20); // eerste dak
            //DrawRoof(paperCanvas, colorBrush, 250, 150, 80, 60); // tweede dak
            //DrawLogo(paperCanvas, colorBrush, 10, 10, 50);
            DrawHouse(paperCanvas, colorBrush, 50, 50, 80, 80);
        }

        private void DrawHouse(Canvas drawingArea, SolidColorBrush brushToUse, double topX, double topY, double width, double height)
        {
            width /= 2;
            height -= width;
            DrawTriangle(drawingArea, brushToUse, topX, topY, width, height);
            DrawTriangle(drawingArea, brushToUse, topX + 2 * width, topY, -1 * width, height);
            DrawLogo(drawingArea, brushToUse, topX, topY, width);
            DrawLogo(drawingArea, brushToUse, topX + width, topY, width);
        }

        private void DrawLogo(Canvas drawingArea, SolidColorBrush brushToUse, double topX, double topY, double size)
        {
            DrawSquare(drawingArea, brushToUse, topX, topY, size);
            DrawSquare(drawingArea, brushToUse, topX, topY, size / 3 * 2);
            DrawSquare(drawingArea, brushToUse, topX, topY, size / 3);
        }

        private void DrawSquare(Canvas drawingArea, SolidColorBrush brushToUse, double topX, double topY, double size)
        {
            Rectangle newSquare = new Rectangle();
            newSquare.Height = size;
            newSquare.Width = size;
            newSquare.StrokeThickness = 2;
            newSquare.Margin = new Thickness(topX, topY, 0, 0);
            newSquare.Stroke = brushToUse;
            drawingArea.Children.Add(newSquare);
        }

        private void DrawRoof(Canvas drawingArea, SolidColorBrush brushToUse, double topX, double topY, double width, double height)
        {
            DrawTriangle(drawingArea, brushToUse, topX, topY, width, height);
            DrawTriangle(drawingArea, brushToUse, topX + 2 * width, topY, -1 * width, height);
        }

        private void DrawTriangle(Canvas drawingArea, SolidColorBrush brushToUse, double topX, double topY, double width, double height)
        {
            Polygon triangle = new Polygon();
            System.Windows.Point point1 = new Point(topX, topY);
            System.Windows.Point point2 = new Point(topX + width, topY);
            System.Windows.Point point3 = new Point(topX + width, topY - height);
            PointCollection myPointCollection = new PointCollection();
            myPointCollection.Add(point1);
            myPointCollection.Add(point2);
            myPointCollection.Add(point3);
            triangle.Points = myPointCollection;
            triangle.Stroke = brushToUse;
            triangle.StrokeThickness = 1;
            drawingArea.Children.Add(triangle);
        }

        /*private void DrawTriangle(Canvas drawingArea, SolidColorBrush brushToUse, double topX, double topY, double width, double height)
        {
            DrawLine(drawingArea, brushToUse, topX, topY, topX + width, topY);
            DrawLine(drawingArea, brushToUse, topX + width, topY, topX + width, topY - height);
            DrawLine(drawingArea, brushToUse, topX + width, topY - height, topX, topY);
        }

        private void DrawLine(Canvas drawingArea, SolidColorBrush brushToUse, double X1, double Y1, double X2, double Y2)
        {
            Line newLine = new Line();
            newLine.X1 = X1; newLine.Y1 = Y1;
            newLine.X2 = X2; newLine.Y2 = Y2;
            newLine.StrokeThickness = 1;
            newLine.Stroke = brushToUse;
            drawingArea.Children.Add(newLine);
        }*/
    }
}
