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

namespace Opgave_2p5
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

        private void HoverTextBox_MouseEnter(object sender, MouseEventArgs e)
        {
            hoverTextBox.Text = "Over button";
        }

        private void HoverTextBox_MouseLeave(object sender, MouseEventArgs e)
        {
            hoverTextBox.Text = "Not over button";
        }

        private void HoverTextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }
    }
}
