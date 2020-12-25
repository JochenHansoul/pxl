using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Media;

namespace BalloonDrawing
{
    public class SpaceShip : Balloon
    {
        public SpaceShip(int x = 50, int y = 50, double diameter = 20, string name = "Nieuwe ballon")
            : base() // ik kan hier neit al de parameters opnieuw inzetten, Balleen does not contain constructor with 8 arguments
        {
            CreateEllipse();
            _name = name;
            _xCoord = x;
            _yCoord = y;
            _diameter = diameter;
            UpdateEllipse();
        }

        protected override void UpdateEllipse()
        {
            _ellipse.Stroke = new SolidColorBrush(_color);
            _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
            _ellipse.Width = _diameter * 1.5;
            _ellipse.Height = _diameter;
        }
    }
}
