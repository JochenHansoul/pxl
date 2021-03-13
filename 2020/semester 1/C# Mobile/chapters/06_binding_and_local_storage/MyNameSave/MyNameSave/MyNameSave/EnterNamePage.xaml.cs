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
    public partial class EnterNamePage : ContentPage
    {
        public EnterNamePage()
        {
            InitializeComponent();
        }

        private void SaveName(object sender, EventArgs e)
        {
            string filename = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "names.txt");

            File.WriteAllText(filename, nameInput.Text);
        }
    }
}