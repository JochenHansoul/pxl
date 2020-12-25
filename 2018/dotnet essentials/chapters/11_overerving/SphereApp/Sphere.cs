using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace SphereApp
{
    public class Sphere
    {
        // member variabelen
        protected double _xCoord = 100;
        protected double _yCoord = 100;
        protected Ellipse _ellipse;

        // properties
        public int X
        {
            set { _xCoord = value; Redraw(); }
        }

        public int Y
        {
            set { _yCoord = value; Redraw(); }
        }

        // methods
        public virtual void CreateEllipse(Canvas drawingCanvas)
        {
            _ellipse = new Ellipse()
            {
                Stroke = new SolidColorBrush(Colors.Black),
                StrokeThickness = 2,
                Width = 40,
                Height = 40,
                Margin = new Thickness(_xCoord, _yCoord, 0, 0)
            };
            drawingCanvas.Children.Add(_ellipse);
        }

        public virtual void Redraw()
        {
            if (_ellipse != null)
            {
                _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
            }
        }
    }
}
