using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace DominationGame
{
    public class Grid
    {
        private Block[,] _grid;
        private double _sizeGrid;
        private double _marginX;
        private double _marginY;
        public int DimensionGrid { get; }

        // constructor
        public Grid(int dimension, double marginX = 10, double marginY = 10,  double sizeGrid = 320)
        {
            DimensionGrid = dimension;
            _marginX = marginX;
            _marginY = marginY;
            _sizeGrid = sizeGrid;
            _grid = new Block[dimension, dimension];
            FillGrid();
        }

        //properties
        public double SizeBlock
        {
            get => _grid[0, 0].Size;
            set
            {
                _sizeGrid = DimensionGrid * value;
                Redraw();
            }
        }

        public double SizeGrid
        {
            get => _sizeGrid;
            set
            {
                _sizeGrid = value;
                Redraw();
            }
        }

        public double MarginX
        {
            get => _marginX;
            set
            {
                _marginX = value;
                Redraw();
            }
        }

        public double MarginY
        {
            get => _marginY;
            set
            {
                _marginY = value;
                Redraw();
            }
        }

        // methods
        private void FillGrid()
        {
            double sizeBlock = _sizeGrid / DimensionGrid;
            double marginBlockX = _marginX, marginBlockY = _marginY;
            for (int column = 0; column < DimensionGrid; column++)
            {
                for (int row = 0; row < DimensionGrid; row++)
                {
                    _grid[row, column] = new Block(sizeBlock, marginBlockX, marginBlockY);
                    marginBlockX += sizeBlock;
                }
                marginBlockX = _marginX;
                marginBlockY += sizeBlock;
            }
        }

        private void Redraw()
        {
            double sizeBlock = _sizeGrid / DimensionGrid;
            double marginXBlock = _marginX, marginYBlock = _marginY;
            for (int i = 0; i < DimensionGrid; i++)
            {
                for (int j = 0; j < DimensionGrid; j++)
                {
                    Block block = _grid[j, i];
                    block.Size = sizeBlock;
                    block.MarginX = marginXBlock;
                    block.MarginY = marginYBlock;
                    marginXBlock += sizeBlock;
                }
                marginXBlock = _marginX;
                marginYBlock += sizeBlock;
            }
        }

        //private void Reposition()
        //{
        //    double sizeBlock = _sizeGrid / DimensionGrid;
        //    double marginXBlock = _marginX, marginYBlock = _marginY;
        //    for (int i = 0; i < DimensionGrid; i++)
        //    {
        //        for (int j = 0; j < DimensionGrid; j++)
        //        {
        //            Block block = _grid[j, i];
        //            block.MarginX = marginXBlock;
        //            block.MarginY = marginYBlock;
        //            marginXBlock += sizeBlock;
        //        }
        //        marginXBlock = _marginX;
        //        marginYBlock += sizeBlock;
        //    }
        //}

        public void GetCoordinates(double x, double y, out int row, out int column)
        {
            double xCoord = x - _marginX;
            double yCoord = y - _marginY;
            double sizeBlock = SizeBlock;
            row = (int)(xCoord / sizeBlock);
            column = (int)(yCoord / sizeBlock);
        }

        public void ClaimBlocks(int row1, int column1, int row2, int column2, Players currentPlayer)
        {
            //if (row2 > SizeGrid && column2 > SizeGrid) throw new Exception("Can't do this move"); // not necessary anymore
            Block block1 = _grid[row1, column1];
            if (block1.Player != Players.none) throw new Exception("Already taken");
            Block secondBlock = _grid[row2, column2];
            if (secondBlock.Player != Players.none) throw new Exception("Can't do this move");
            block1.ClaimedBy(currentPlayer);
            secondBlock.ClaimedBy(currentPlayer);
        }

        public bool MovePossibleFor(int rows, int columns, int adRow, int adColumn)
        {
            bool movePossible = false;
            Block block1, block2;
            Players noPlayer = Players.none;
            for (int row = 0; row < rows; row++)
            {
                for (int column = 0; column < columns; column++)
                {
                    block1 = _grid[row, column];
                    block2 = _grid[row + adRow, column + adColumn];
                    if (block1.Player == noPlayer && block2.Player == noPlayer)
                    {
                        movePossible = true;
                    }
                }
            }
            return movePossible;
        }

        public void DisplayOn(Canvas drawingCanvas)
        {
            for (int row = 0; row < DimensionGrid; row++)
            {
                for (int comumn = 0; comumn < DimensionGrid; comumn++)
                {
                    _grid[row, comumn].DisplayOn(drawingCanvas);
                }
            }
        }
    }
}
