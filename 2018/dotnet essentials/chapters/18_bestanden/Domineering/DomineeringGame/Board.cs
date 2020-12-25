using System;
using System.IO;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace DomineeringGame
{
    internal class Board
    {
        private static readonly SolidColorBrush blackBrush = new SolidColorBrush(Colors.Black);
        private static readonly SolidColorBrush redBrush = new SolidColorBrush(Colors.Red);
        private static readonly SolidColorBrush blueBrush = new SolidColorBrush(Colors.Blue);
        private Block[,] _grid;
        private static double _sizeSquare;
        private int _sizeGrid;

        public void CreateRoster(Canvas canvas, int size)
        {
            double margin = canvas.Width - 14;
            _sizeGrid = size;
            _grid = new Block[size, size];

            //Not needed, margin correction
            for (int i = 0; i < size + 1; i++)
            //{
            //    Line vertLine = new Line();
            //    vertLine.Stroke = blackBrush;
            //    vertLine.StrokeThickness = 2;
            //    vertLine.X1 = (margin / size * i) + 7;
            //    vertLine.X2 = vertLine.X1;
            //    vertLine.Y1 = 7;
            //    vertLine.Y2 = canvas.Height - 7;
            //    canvas.Children.Add(vertLine);
            //}

            //for (int i = 0; i < size + 1; i++)
            //{
            //    Line horiLine = new Line();
            //    horiLine.Stroke = blackBrush;
            //    horiLine.StrokeThickness = 2;
            //    horiLine.Y1 = (margin / size * i) + 7;
            //    horiLine.Y2 = horiLine.Y1;
            //    horiLine.X1 = 7;
            //    horiLine.X2 = canvas.Height - 7;
            //    canvas.Children.Add(horiLine);
            //}

            _sizeSquare = (canvas.Width - 14 - ((size + 1) * 2)) / size;
            CreateBlocks(canvas);
        }

        private void CreateBlocks(Canvas canvas)
        {
            for (int i = 0; i < _grid.GetLength(0); i++)
            {
                for (int j = 0; j < _grid.GetLength(1); j++)
                {
                    _grid[i, j] = new Block(i, j, _sizeSquare);
                    canvas.Children.Add(_grid[i, j].square);
                }
            }
        }

        public void ColorBlock(int row, int col, int player)
        {
            //CHECK CORRECT INPUT
            if (row < 0 || row > _sizeGrid - 1 || col < 0 || col > _sizeGrid - 1)
            {
                throw new DomineeringException("Click inside a valid part of the gameboard, please try again!");
            }

            //IF CORRECT, TEST IF PLACEMENT IS POSSIBLE
            if (IsCurrectMovePossible(row, col, player))
            {
                //PRESTEPS TO WRITE
                string destination = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
                string file = System.IO.Path.Combine(destination, "domineering.txt");
                StreamWriter s = File.AppendText(file);
                //COLOR BLOCK
                if (player == 1)
                {
                    ChangeColor(row, col, redBrush);
                    ChangeColor(row + 1, col, redBrush);
                    //WRITE
                    s.WriteLine($"Player {player} ({row},{col}) ({row + 1},{col})");
                }
                else
                {
                    ChangeColor(row, col, blueBrush);
                    ChangeColor(row, col + 1, blueBrush);
                    //WRITE
                    s.WriteLine($"Player {player} ({row},{col}) ({row},{col + 1})");
                }
                //IMPORTANT CLOSE!
                s.Close();
            }
            else
            {
                throw new DomineeringException("This move is not possible, please try another rectangle!");
            }

        }

        private void ChangeColor(int row, int col, SolidColorBrush brush)
        {
            _grid[col, row].square.Fill = brush;
            _grid[col, row].square.Stroke = brush;
        }

        //CHECKS EACH ROUND IF GAME IS OVER
        public bool IsAnyMovePossible(int player)
        {
            bool foundOpenSpace = false;
            if (player == 1)
            {
                //SEARCH FOR VERTICAL OPEN SPACES OF 2 LONG
                for (int j = 0; j < _grid.GetLength(1) - 1; j++)
                {
                    for (int i = 0; i < _grid.GetLength(0); i++)
                    {
                        if (!_grid[i, j].IsUsedOnBoard && !_grid[i, j + 1].IsUsedOnBoard)
                        {
                            foundOpenSpace = true;
                        }
                    }
                }
            }
            else
            {
                //SEARCH FOR HORIZONTAL OPEN SPACES OF 2 LONG
                for (int i = 0; i < _grid.GetLength(0) - 1; i++)
                {
                    for (int j = 0; j < _grid.GetLength(1); j++)
                    {
                        if (!_grid[i, j].IsUsedOnBoard && !_grid[i + 1, j].IsUsedOnBoard)
                        {
                            foundOpenSpace = true;
                        }
                    }
                }
            }

            if (foundOpenSpace)
            {
                return true;
            }

            return false;
        }

        public bool IsCurrectMovePossible(int row, int col, int player)
        {
            if (player == 1)
            {
                if (row == _sizeGrid - 1)
                {
                    //RETURN NOW OTHERWISE AN OUT-OF-BOUND-EXCEPTION WILL OCCUR
                    return false;
                }
                if (!_grid[col, row].IsUsedOnBoard && !_grid[col, row + 1].IsUsedOnBoard)
                {
                    //MOVE IS VALID SO MAKE BLOCKS USED AND OWNED
                    _grid[col, row].IsUsedOnBoard = true;
                    _grid[col, row].OwnedByPlayer = 1;
                    _grid[col, row + 1].IsUsedOnBoard = true;
                    _grid[col, row + 1].OwnedByPlayer = 1;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if (col == _sizeGrid - 1)
                {
                    //RETURN NOW OTHERWISE A OUT-OF-BOUND-EXCEPTION WILL OCCUR
                    return false;
                }
                if (!_grid[col, row].IsUsedOnBoard && !_grid[col + 1, row].IsUsedOnBoard)
                {
                    //MOVE IS VALID SO MAKE BLOCKS USED AND OWNED
                    _grid[col, row].IsUsedOnBoard = true;
                    _grid[col, row].OwnedByPlayer = 2;
                    _grid[col + 1, row].IsUsedOnBoard = true;
                    _grid[col + 1, row].OwnedByPlayer = 2;
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }
}