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

namespace SphereApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            //Sphere sphere = new Sphere();
            //sphere.CreateEllipse(paperCanvas);

            //Bubble bubble = new Bubble();
            //bubble.CreateEllipse(paperCanvas);
            //bubble.Redraw();

            //ColoredSphere coloredSphere = new ColoredSphere(Colors.Blue);
            //coloredSphere.CreateEllipse(paperCanvas);
            //coloredSphere.Redraw();
            //coloredSphere.Color = Colors.Bisque;

            Ball ball = new Ball();
            ball.CreateEllipse(paperCanvas);
            ball.MoveRight(100);
            ball.MoveLeft(200);
            ball.Y = 20;

            PoolBall poolBall = new PoolBall();
            poolBall.CreateEllipse(paperCanvas);
            poolBall.MoveRight(500);
        }
    }
}
