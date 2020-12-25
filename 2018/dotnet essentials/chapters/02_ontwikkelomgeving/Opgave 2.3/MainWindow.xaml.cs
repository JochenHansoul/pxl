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

namespace Oef_2._3
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

        private void NameTextBlock_Loaded(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Jochen Hansoul");
        }

        private void NameButton_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("28 jaar");
        }
    }
}
