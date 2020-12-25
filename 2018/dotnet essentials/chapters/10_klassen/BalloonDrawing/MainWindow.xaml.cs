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

namespace BalloonDrawing
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Balloon balloon, spaceShip;

        public MainWindow()
        {
            InitializeComponent();

            balloon = new Balloon();
            balloon.DisplayOn(paperCanvas);
            balloon.XCoord = 75;
            balloon.YCoord = 75;
            balloon.ChangeSize(70);
            balloon.ChangeSize(20);

            spaceShip = new SpaceShip();
            spaceShip.DisplayOn(paperCanvas);
        }

        private void MoveBalloon_Click(object sender, RoutedEventArgs e)
        {
            Balloon movedBalloon = balloon;
            string action = Convert.ToString(((Button) sender).Content);
            switch (action)
            {
                case "Up":
                    movedBalloon.MoveUp(20);
                    break;
                case "Down":
                    movedBalloon.MoveUp(-20);
                    break;
                case "Left":
                    movedBalloon.MoveRight(-20);
                    break;
                case "Right":
                    movedBalloon.MoveRight(20);
                    break;
                default:
                    MessageBox.Show("Move balloon got wrong value");
                    break;
            }
        }
    }
}
