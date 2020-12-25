using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.IO;

namespace DominationGame
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Grid grid;
        private Players player;
        private bool movePossible;
        int gridSize;
        StreamWriter writer;

        public MainWindow()
        {
            InitializeComponent();

            grid = new Grid(8);
            grid.DisplayOn(paperCanvas);

            /*
            grid.SizeGrid = 160;
            grid.MarginY = 60;
            grid.MarginX = 40;
            grid.SizeBlock = 10;
            */

            gridSize = grid.DimensionGrid;
            movePossible = grid.MovePossibleFor(gridSize, gridSize - 1, 0, 1);
            player = Players.red;
            playerLabel.Content = player + " player";
            writer = null;
        }

        private void PaperCanvas_MouseMove(object sender, MouseEventArgs e)
        {
            mouseMoveLabel.Content = Convert.ToString(e.GetPosition(paperCanvas));
        }

        private void PaperCanvas_MouseDown(object sender, MouseButtonEventArgs e)
        {
            try
            {
                if (movePossible)
                {
                    writer = File.CreateText("DominationGameHistory.txt");

                    // getting coordinates first block
                    string position = Convert.ToString(e.GetPosition(paperCanvas));
                    string[] coordinates = position.Split(';');
                    double x = Convert.ToDouble(coordinates[0]), y = Convert.ToDouble(coordinates[1]);
                    grid.GetCoordinates(x, y, out int row1, out int column1);
                    // getting coordinates second block
                    int row2, column2;
                    row2 = row1;
                    column2 = column1;
                    if (player == Players.red)
                    {
                        column2++;
                    }
                    else
                    {
                        row2++;
                    }
                    if (row1 >= 0 && row2 < gridSize && column1 >= 0 && column2 < gridSize) // only if the chosen block is within range grid
                    {
                        blockLabel.Content = $"{row1};{column1}";
                        grid.ClaimBlocks(row1, column1, row2, column2, player);
                        writer.WriteLine($"({row1};{column1})({row2};{column2})");
                        writer.WriteLine();
                        if (player != Players.red) // not == red player! Need to check other player's move
                        {
                            movePossible = grid.MovePossibleFor(gridSize, gridSize - 1, 0, 1); // checking red player
                        }
                        else
                        {
                            movePossible = grid.MovePossibleFor(gridSize - 1, gridSize, 1, 0); // checking blue player
                        }
                        if (movePossible)
                        {
                            player = (player == Players.red) ? Players.blue : Players.red;
                            playerLabel.Content = player + " player";
                        }
                        else
                        {
                            MessageBox.Show(player + " player wins");
                        }

                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                if (writer != null)
                {
                    writer.Close();
                }
            }
        }

    }
}
