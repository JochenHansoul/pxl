using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace MyNameSave
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class ShowNamePage : ContentPage
    {
        public ShowNamePage()
        {
            InitializeComponent();

            string fileName = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "names.txt");
            // LocalApplicationData is een map die elke android os heeft om informatie op te slaan
            if (File.Exists(fileName))
            {
                nameLabel.Text = File.ReadAllText(fileName);
            }
            else
            {
                nameLabel.Text = "Please save your name first";
            }
        }
    }
}