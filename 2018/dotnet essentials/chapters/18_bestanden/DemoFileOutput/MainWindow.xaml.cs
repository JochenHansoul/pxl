using System;
using System.Collections.Generic;
using System.IO;
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

namespace DemoFileOutput
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

        private void WriteButton_Click(object sender, RoutedEventArgs e)
        {
            string folderPath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments); // gaat het folderpad 'my documents' opzoeken
            //statusLabel.Content = "Writing to: " + folderPath;
            string filePath = System.IO.Path.Combine(folderPath, "myfile.txt");
            StreamWriter writer = File.CreateText(filePath);
            writer.WriteLine("Dit is lijn 1");
            writer.WriteLine("Dit is lijn 2");
            writer.WriteLine("Dit is lijn 3");
            writer.Close();
        }

        private void ReadButton_Click(object sender, RoutedEventArgs e)
        {
            string folderPath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
            string filePath = System.IO.Path.Combine(folderPath, "myfile.txt");
            StreamReader reader = File.OpenText(filePath);
            string line = reader.ReadLine();
            while (line != null)
            {
                fileTextBox.AppendText(line);
                fileTextBox.AppendText(Environment.NewLine);
                line = reader.ReadLine();
            }
            reader.Close();
        }
    }
}
