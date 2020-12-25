using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace BalloonDrawing
{
    public class Balloon
    {
        // member variables
        const int burstRadius = 50;
        protected Ellipse _ellipse;
        protected string _name;
        protected int _xCoord;
        protected int _yCoord;
        protected double _diameter;
        protected Color _color = Colors.Blue;

        // constructor
        public Balloon(int x = 50, int y = 50, double diameter = 20, string name = "Nieuwe ballon")
        {
            CreateEllipse();
            _name = name;
            _xCoord = x;
            _yCoord = y;
            _diameter = diameter;
            //_color = color; //je kan geen default waarde instellen voor color, must be compile-time constant
            UpdateEllipse();
        }

        // properties
        public int XCoord
        {
            get { return _xCoord; }
            set { _xCoord = value; UpdateEllipse(); }
        }

        public int YCoord
        {
            get { return _yCoord; }
            set { _yCoord = value; UpdateEllipse(); }
        }

        public string BalloonName
        {
            get { return _name; }
            set { _name = value; UpdateEllipse(); }
        }

        public Color balloonColor
        {
            get { return _color; }
            set { _color = value; UpdateEllipse(); }
        }

        public double Area
        {
            get => CalculateArea();
        }

        // methods
        public void MoveRight(int xStep)
        {
            _xCoord += xStep;
            UpdateEllipse();
        }

        public void MoveUp(int yStep)
        {
            _yCoord -= yStep;
            UpdateEllipse();
        }

        public void ChangeSize(int change)
        {
            _diameter += change;
            Burst();
            UpdateEllipse();
        }

        public void ChangeColor(Color color)
        {
            _color = color;
            UpdateEllipse();
        }

        public void DisplayOn(Canvas drawingCanvas)
        {
            drawingCanvas.Children.Add(_ellipse);
        }

        protected void CreateEllipse()
        {
            _ellipse = new Ellipse()
            {
                StrokeThickness = 2
            };
        }

        protected virtual void UpdateEllipse()
        {
            _ellipse.Stroke = new SolidColorBrush(_color);
            _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
            _ellipse.Width = _diameter;
            _ellipse.Height = _diameter;
        }

        protected virtual double CalculateArea()
        {
            double radius = _diameter / 2.0;
            return Math.PI * Math.Pow(radius, 2);
        }

        private void Burst()
        {
            if (_diameter > burstRadius)
            {
                MessageBox.Show("Balloon bursted at " + _diameter);
                _diameter = 0;
            }
        }
    }
}
