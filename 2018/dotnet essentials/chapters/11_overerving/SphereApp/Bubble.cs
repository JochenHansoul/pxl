using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace SphereApp
{
    public class Bubble : Sphere
    {
        protected int radius = 60;

        public int Size
        {
            set { radius = value; Redraw(); }
        }

        public override void Redraw()
        {
            if (_ellipse != null)
            {
                _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
                _ellipse.Width = 2 * radius;
                _ellipse.Height = 2 * radius;
            }
        }

        public void MoveVertical(int amount)
        {
            _yCoord += amount;
            Redraw();
        }
    }
}
