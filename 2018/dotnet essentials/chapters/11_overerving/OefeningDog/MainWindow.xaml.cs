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

namespace OefeningDog
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Animal whatever, dog, smallDog;

        public MainWindow()
        {
            InitializeComponent();

            whatever = new Animal("Gonzo");
            dog = new Dog("Pluto");
            smallDog = new SmallDog("Fifike");
            Dog standardDog = new Dog(5);

            PrintAnimal(whatever);
            PrintAnimal(dog);
            PrintAnimal(smallDog);
        }

        private void PrintAnimal(Animal animal)
        {
            string line = $"Animal {animal.Name} Sounds as: {animal.Sound()}";
            MessageBox.Show(line);
        }
    }
}
