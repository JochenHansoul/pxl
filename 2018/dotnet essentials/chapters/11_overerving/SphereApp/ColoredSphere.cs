using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Media;

namespace SphereApp
{
    public class ColoredSphere : Sphere
    {
        protected Color _color;

        public ColoredSphere(Color color)
        {
            _color = color;
        }

        public Color Color
        {
            set { _color = value; Redraw(); }
        }

        public override void Redraw()
        {
            if (_ellipse != null)
            {
                _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
                _ellipse.Stroke = new SolidColorBrush(_color);
            }
        }
    }
}
