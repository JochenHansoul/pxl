using System.Collections.Generic;
using System.Linq;
using AdventureTime.Models;
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

            SetFavoriteCharacter();
        }

        private async void SetFavoriteCharacter()
        {
            List<Character> characters = await App.Database.GetCharactersAsync();
            Character character = characters.FirstOrDefault(o => o.IsFavorite);

            favoriteCharacterLabel.Text = (character != null && character.IsFavorite) ? character.FullName : "No fovorite character selected";
        }
    }
}