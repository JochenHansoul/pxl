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
using System.Windows.Threading;

namespace Exercise10_BouncingBall
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        DispatcherTimer bouncingBallTimer = new DispatcherTimer();

        private Ellipse ball;
        private Ellipse poolHole;

        private double diameter = 20;
        private static double beginX = 10, beginY = 10;
        private double x = beginX, y = beginY;
        private int xChange = 5, yChange = 2;


        public MainWindow()
        {
            InitializeComponent();

            SolidColorBrush blackBrush = new SolidColorBrush(Colors.Black);
            SolidColorBrush blueBrush = new SolidColorBrush(Colors.Blue);
            DrawBall(ballCanvas, blackBrush, x, y, diameter);
            DrawPoolHole(ballCanvas, blueBrush, diameter + 5);
            coordinatesLabel.Content = $"X:{x}  Y:{y}";

            bouncingBallTimer.Interval = TimeSpan.FromMilliseconds(50);
            bouncingBallTimer.Tick += BouncingBallTimer_Tick;
        }

        private void BouncingBallTimer_Tick(object sender, EventArgs e)
        {
            MoveBall(diameter, ref x, ref y, ref xChange, ref yChange);
            ball.Margin = new Thickness(x, y, 0, 0);
            coordinatesLabel.Content = $"X:{x}  Y:{y}";
            DropBall(ball, poolHole);
        }

        private void DrawBall(Canvas drawingArea, SolidColorBrush brushToUse, double x, double y, double diameter)
        {
            ball = new Ellipse()
            {
                Stroke = brushToUse,
                StrokeThickness = 1,
                Margin = new Thickness(x, y, 0, 0),
                Width = diameter,
                Height = diameter
            };
            drawingArea.Children.Add(ball);
        }

        private void DrawPoolHole(Canvas drawingArea, SolidColorBrush brushToUse, double diameter)
        {
            double x = drawingArea.Width / 2 - diameter / 2;
            double y = drawingArea.Height / 2 - diameter / 2;

            poolHole = new Ellipse()
            {
                Stroke = brushToUse,
                StrokeThickness = 1,
                Fill = brushToUse,
                Margin = new Thickness(x, y, 0, 0),
                Width = diameter,
                Height = diameter
            };
            drawingArea.Children.Add(poolHole);
        }

        private void MoveBall(double diameter, ref double x, ref double y, ref int xChange, ref int yChange)
        {
            if ((x <= 0) || (x >= ballCanvas.Width - diameter))
            {
                xChange = -xChange;
            }
            if ((y <= 0) || (y >= ballCanvas.Height - diameter))
            {
                yChange = -yChange;
            }
            x += xChange;
            y += yChange;
        }

        private void DropBall(Ellipse ball, Ellipse poolHole)
        {
            double xBall = ball.Margin.Left;
            double yBall = ball.Margin.Top;
            double radiusPool = poolHole.Width / 2;
            double xPoolHole = poolHole.Margin.Left;
            double yPoolHole = poolHole.Margin.Top;
            if ((xBall >= xPoolHole - radiusPool) && (xBall <= xPoolHole + radiusPool) &&
                (yBall >= yPoolHole - radiusPool) && (yBall <= yPoolHole + radiusPool))
            {
                bouncingBallTimer.Stop();
                ball.Visibility = Visibility.Collapsed;
                xChangeButton.IsEnabled = false;
                yChangeButton.IsEnabled = false;
                ballCanvas.IsEnabled = false;
            }
        }

        private void BallCanvas_MouseUp(object sender, MouseButtonEventArgs e)
        {
            if (bouncingBallTimer.IsEnabled)
            {
                bouncingBallTimer.Stop();
            }
            else
            {
                bouncingBallTimer.Start();
            }
        }

        private void XChangeButton_Click(object sender, RoutedEventArgs e)
        {
            xChange = -xChange;
        }

        private void YChangeButton_Click(object sender, RoutedEventArgs e)
        {
            yChange = -yChange;
        }

        private void ResetButton_Click(object sender, RoutedEventArgs e)
        {
            x = beginX;
            y = beginY;
            if(xChange < 0)
            {
                xChange = -xChange;
            }
            if (yChange < 0)
            {
                yChange = -yChange;
            }
            ball.Margin = new Thickness(beginX, beginY, 0, 0);
            ball.Visibility = Visibility.Visible;
            xChangeButton.IsEnabled = true;
            yChangeButton.IsEnabled = true;
            ballCanvas.IsEnabled = true;
        }
    }
}
