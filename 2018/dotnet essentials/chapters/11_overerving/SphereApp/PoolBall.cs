using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace SphereApp
{
    public class PoolBall : Ball
    {
        protected double _maxX;

        public override void CreateEllipse(Canvas drawingCanvas)
        {
            base.CreateEllipse(drawingCanvas);
            _maxX = drawingCanvas.Width;
            _maxX -= _ellipse.Width;
            Console.WriteLine(_maxX);
        }

        public override void MoveLeft(int value)
        {
            base.MoveLeft(value);
            if (_xCoord < 0)
            {
                _xCoord = 0;
                Redraw();
            }
        }

        public override void MoveRight(int value)
        {
            base.MoveRight(value);
            if (_xCoord > _maxX)
            {
                _xCoord = _maxX;
                Redraw();
            }
        }
    }
}
