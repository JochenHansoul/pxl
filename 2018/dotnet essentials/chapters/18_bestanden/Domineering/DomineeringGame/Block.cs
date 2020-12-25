using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;

namespace DomineeringGame
{
    class Block
    {
        public bool IsUsedOnBoard { get; set; } = false;
        public int OwnedByPlayer { get; set; } //0 = not owned, 1 = player 1, 2 = player 2
        public Rectangle square = new Rectangle();
        private static readonly SolidColorBrush WhiteBrush = new SolidColorBrush(Colors.White);

        public Block(int row, int col, double size)
        {
            square.Width = size;
            square.Height = size;
            double marginX = 7 + ((row + 1) * 2) + (row * size);
            double marginY = 7 + ((col + 1) * 2) + (col * size);
            square.Margin = new Thickness(marginX, marginY, 0, 0);
            square.Fill = WhiteBrush;
            square.Stroke = WhiteBrush;
            //squire.Stroke = new SolidColorBrush(Colors.Black);
        }
    }
}
