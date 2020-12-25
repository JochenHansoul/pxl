using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SphereApp
{
    public class Ball : Sphere
    {
        public virtual void MoveLeft(int value)
        {
            _xCoord -= value;
            Redraw();
        }
        public virtual void MoveRight(int value)
        {
            _xCoord += value;
            Redraw();
        }
    }
}
