using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AdventureTime
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class FavoriteCharacter : ContentPage
    {
        public FavoriteCharacter()
        {
            InitializeComponent();

            string fileName = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "favorite_characters.txt");
            if (File.Exists(fileName))
            {
                string[] firstandLastName = File.ReadAllText(fileName).Split(';');
                favoriteCharacterLabel.Text = $"{firstandLastName[0]} {firstandLastName[1]}";
            }
            else
            {
                favoriteCharacterLabel.Text = "No fovorite character selected";
            }
        }
    }
}