﻿using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Exercise05
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void drawButton_Click(object sender, RoutedEventArgs e)
        {
            SolidColorBrush brush = new SolidColorBrush(Colors.Black);

            DrawLogo(paperCanvas, brush, 10, 20);
            DrawLogo(paperCanvas, brush, 100, 100);
            DrawTriangle2(paperCanvas, brush, 100, 10, 40, 40);
            DrawTriangle2(paperCanvas, brush, 10, 100, 20, 60);
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
