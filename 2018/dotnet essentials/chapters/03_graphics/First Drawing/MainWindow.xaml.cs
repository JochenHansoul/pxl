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

namespace First_Drawing
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void DrawButton_Click(object sender, RoutedEventArgs e)
        {
            Rectangle lowerRectangle = new Rectangle();
            lowerRectangle.Width = 100;
            lowerRectangle.Height = 100;
            lowerRectangle.Margin = new Thickness(10, 50, 0, 0);
            lowerRectangle.Stroke = new SolidColorBrush(Colors.Red);
            lowerRectangle.StrokeThickness = 12;
            lowerRectangle.Fill = new SolidColorBrush(Colors.MediumPurple);

            Rectangle upperRectangle = new Rectangle();
            upperRectangle.Width = 100; // zijn geen pixels, dio = 1/96 van inch
            upperRectangle.Height = 50;
            upperRectangle.Margin = new Thickness(10, 10, 0, 0);
            upperRectangle.StrokeThickness = 7;
            upperRectangle.Stroke = new SolidColorBrush(Colors.Green);

            Line lineInRectangle = new Line();
            lineInRectangle.X1 = 160; lineInRectangle.Y1 = 20;
            lineInRectangle.X2 = 190; lineInRectangle.Y2 = 50;
            lineInRectangle.Stroke = new SolidColorBrush(Colors.Brown);
            lineInRectangle.StrokeThickness = 4;

            Ellipse cirkel1 = new Ellipse();
            cirkel1.Width = 100;
            cirkel1.Height = 100;
            cirkel1.Stroke = new SolidColorBrush(Colors.Black);
            cirkel1.Fill = new SolidColorBrush(Colors.Red);
            cirkel1.Margin = new Thickness(10, 10, 0, 0);

            // afbeeldingen eerst in geheugen computer laden
            BitmapImage afbeeldingGeluid = new BitmapImage();
            afbeeldingGeluid.BeginInit();
            //afbeeldingGeluid.UriSource = new Uri("imagenaam.jpg", UriKind.RelativeOrAbsolute); wanneer in map geladen is
            afbeeldingGeluid.UriSource = new Uri(@"C:\Users\11802208\Pictures\volumeknop.png", UriKind.Absolute);
            afbeeldingGeluid.EndInit();

            Image geluidsknop = new Image();
            geluidsknop.Source = afbeeldingGeluid;
            geluidsknop.Width = 100;
            geluidsknop.Height = 100;
            geluidsknop.Margin = new Thickness(150, 150, 0, 0);

            //2e afbeelding - ik denk dat deze niet lukt
            BitmapImage imgDrone = new BitmapImage();
            imgDrone.BeginInit();
            imgDrone.UriSource = new Uri("flyingDrone.jpg", UriKind.RelativeOrAbsolute);
            imgDrone.EndInit();

            Image drone = new Image();
            drone.Source = imgDrone;
            drone.Width = 100;
            drone.Height = 100;
            drone.Margin = new Thickness(250, 10, 0, 0);


            paperCanvas.Children.Add(upperRectangle);
            paperCanvas.Children.Add(lowerRectangle);
            paperCanvas.Children.Add(lineInRectangle);
            paperCanvas.Children.Add(cirkel1);
            paperCanvas.Children.Add(geluidsknop);
            //paperCanvas.Children.Add(drone);
        }
    }
}
