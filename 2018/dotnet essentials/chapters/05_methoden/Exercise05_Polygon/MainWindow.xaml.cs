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

namespace Exercise05_Polygon
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
            DrawTriangle2(drawingArea: paperCanvas, brushToUse: black, xPlace: 100, yPlace: 100, width: 200, height: 100);
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
    }
}
