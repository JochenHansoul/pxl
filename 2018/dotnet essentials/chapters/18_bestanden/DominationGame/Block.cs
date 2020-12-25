using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace DominationGame
{
    public class Block
    {
        private static SolidColorBrush _whiteBrush = new SolidColorBrush(Colors.White); // static voor wanneer je geen object voor moet aanmaken
        private static SolidColorBrush _blackBrush = new SolidColorBrush(Colors.Black);
        private static SolidColorBrush _redBrush = new SolidColorBrush(Colors.Red);
        private static SolidColorBrush _blueBrush = new SolidColorBrush(Colors.Blue);

        private Rectangle _block;
        private double _size;
        private double _marginX;
        private double _marginY;
        private Players _player = Players.none;

        // constructor
        public Block(double size, double marginX, double marginY)
        {
            _size = size;
            _marginX = marginX;
            _marginY = marginY;
            CreateBlock();
        }

        // properties
        public double Size
        {
            get => _size;
            set
            {
                if (value > 0)
                {
                    _size = value;
                    Redraw();
                }
                else
                {
                    throw new Exception("Size of block must be greater than 0");
                }
            }
        }

        public double MarginX
        {
            get => _marginX;
            set
            {
                if (value > 0)
                {
                    _marginX = value;
                    ChangePosition();
                }
                else
                {
                    throw new Exception("Margin X of block must be greater than 0");
                }
            }
        }

        public double MarginY
        {
            get => _marginY;
            set
            {
                if (value > 0)
                {
                    _marginY = value;
                    ChangePosition();
                }
                else
                {
                    throw new Exception("Margin Y of block must be greater than 0");
                }
            }
        }

        public Players Player
        {
            get => _player;
            set
            {
                if (value != Players.none)
                {
                    _player = value;
                }
                else
                {
                    throw new Exception("Selected player can not be none");
                }
            }
        }

        // methods
        private void CreateBlock()
        {
            _block = new Rectangle()
            {
                Width = _size,
                Height = _size,
                StrokeThickness = 1,
                Stroke = _blackBrush,
                Margin = new Thickness(_marginX, _marginY, 0, 0),
                Fill = _whiteBrush
            };
        }

        private void Redraw()
        {
            _block.Width = _size;
            _block.Height = _size;
            ChangePosition();
        }

        private void ChangePosition()
        {
            _block.Margin = new Thickness(_marginX, MarginY, 0, 0);
        }

        public void ClaimedBy(Players player)
        {
            Player = player;
            _block.Fill = (player == Players.red) ? _redBrush : _blueBrush;
        }

        public void DisplayOn(Canvas drawingCanvas)
        {
            drawingCanvas.Children.Add(_block);
        }


        /*
         * Haastige notities:
         * alle member variabelen privata behalve constanten (constanden beginnen met hoofdletters)
         * get return owner
         * double x = comumnINDEX + ...
         * voor de positie blokjes te tonen: override ToString()
         */
    }
}
