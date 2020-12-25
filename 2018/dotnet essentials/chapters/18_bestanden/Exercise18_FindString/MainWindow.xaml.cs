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

namespace Exercise18_FindString
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

        private void SearchButton_Click(object sender, RoutedEventArgs e)
        {
            // winworms nemen, geen folderbrowserDialog (het vinkje plaatsen), System.Windows.Forms
            StreamReader reader = null;
            try
            {
                outputTextBox.Text = "";

                // string[] textfiles = Directory.GetFiles(directoryTextBox.Text, "*.txt");
                // foreach (string textfile in textfiles) // dan maakt zij methode

                // string fileName = System.IO.Path.GetFileName(filePath);



                //string defaultPath = @"C:\Users\11802208\Documents\1 .Net Essentials\searchFile1.txt";
                string path = locationTextBox.Text;
                reader = File.OpenText(@path);
                string searchWord = searchTextBox.Text;
                if (searchWord == "") throw new Exception("Must ad a search on value");
                //int begin = path.LastIndexOf("\");
                string splittedPath = path.Substring(4, 10);
                string line = reader.ReadLine();
                while (line != null)
                {
                    outputTextBox.AppendText(splittedPath);
                    string[] splittedLine = line.Split(' ');
                    foreach(string word in splittedLine)
                    {
                        if (word == searchWord)
                        {
                            outputTextBox.AppendText(line);
                            outputTextBox.AppendText(Environment.NewLine);
                        }
                    }
                    line = reader.ReadLine();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message); // System.Windows hiervoor typen!  wbf applicatoe:System.Windows.Form
            }
            finally
            {
                if (reader != null) reader.Close();
            }

            /*
             * 
             * 
             * 
             */
        }
    }
}
