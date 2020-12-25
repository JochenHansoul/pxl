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
using System.Diagnostics;

namespace Exercise20_till_23
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Stopwatch stopwatch;

        private Course[] courses;
        private Dictionary<string, Course> lookup;
        private List<Object> coursesList;

        public MainWindow()
        {
            InitializeComponent();

            stopwatch = new Stopwatch();

            lookup = new Dictionary<string, Course>();
            coursesList = new List<Object>();
            courses = new Course[1000000];
            for (int i = 0; i < courses.Length; i++)
            {
                courses[i] = new Course($"name{i}", $"teacher{i}", 5);
                lookup.Add(courses[i].Name, courses[i]);
                coursesList.Add(courses[i]);
            }

            //courses[0] = new Course(".NET Essentials", "Kris Hermans", 6);
            //courses[1] = new Course("Logisch & Algoritmisch Denken", "Nele Custers", 7);
            //courses[2] = new Course("Webdesign", "Rita Lambrechts", 4);
        }

        private void SearchCourseButton_Click(object sender, RoutedEventArgs e)
        {
            stopwatch.Start();
            string key;
            Course course;

            if (keyTextBox.Text != "")
            {
                key = keyTextBox.Text;
                if (lookup.ContainsKey(key))
                {
                    course = lookup[key];
                    AddText(resultTextBox, key, course);
                }
                else
                {
                    resultTextBox.Clear();
                    resultTextBox.AppendText($"Vak {key} niet gevonden");
                }
            }
            stopwatch.Stop();
            ShowTime(stopwatch.Elapsed);
        }

        private void SearchArrayButton_Click(object sender, RoutedEventArgs e)
        {
            stopwatch.Start();
            string key;
            Course course;
            if (keyTextBox.Text != "")
            {
                key = keyTextBox.Text;
                int counter = 0;
                while (counter < courses.Length)
                {
                    if (key == courses[counter].Name)
                    {
                        course = courses[counter];
                        AddText(resultTextBox, key, course);
                        counter = courses.Length;
                    }
                    counter++;
                }
                if (counter != courses.Length + 1)
                {
                    resultTextBox.Clear();
                    resultTextBox.AppendText($"Vak {key} niet gevonden");
                }

            }
            stopwatch.Stop();
            ShowTime(stopwatch.Elapsed);
        }

        private void searchListButton_Click(object sender, RoutedEventArgs e)
        {
            stopwatch.Start();
            string key;
            Course course;
            if (keyTextBox.Text != "")
            {
                key = keyTextBox.Text;
                int counter = 0;
                while (counter < coursesList.Count)
                {
                    if (key == ((Course) coursesList[counter]).Name)
                    {
                        course = ((Course) coursesList[counter]);
                        AddText(resultTextBox, key, course);
                        counter = courses.Length;
                    }
                    counter++;
                }
                if (counter != coursesList.Count + 1)
                {
                    resultTextBox.Clear();
                    resultTextBox.AppendText($"Vak {key} niet gevonden");
                }
            }
            stopwatch.Stop();
            ShowTime(stopwatch.Elapsed);
        }

        private void AddText(TextBox outputTextBox, string key, Course course)
        {
            resultTextBox.Clear();
            outputTextBox.AppendText($"Vakgegevens voor {key}\n\n");
            outputTextBox.AppendText($"Docent: {course.Teacher}\n");
            outputTextBox.AppendText($"Uren: {course.Hours}");
        }

        private void ShowTime(TimeSpan elapsed)
        {
            MessageBox.Show($"Duur: {elapsed.Seconds} sec en {elapsed.Milliseconds} msec");
            stopwatch.Reset();
        }
    }
}
