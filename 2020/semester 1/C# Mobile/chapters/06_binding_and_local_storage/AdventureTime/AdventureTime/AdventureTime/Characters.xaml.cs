using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AdventureTime.Models;
using Xamarin.Essentials;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AdventureTime
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Characters : ContentPage
    {
        private string _favoriteCharacterFile;
        private ObservableCollection<Character> _characters;
        private Character _favoriteCharacter;

        public Characters()
        {
            InitializeComponent();

            _favoriteCharacterFile = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "favorite_characters.txt");

            _characters = GetAllCharacters();
            charactersListView.ItemsSource = _characters; //moet ItenSource en niet BindingSource zijn!
            _favoriteCharacter = null;
        }

        private ObservableCollection<Character> GetAllCharacters()
        {
            return new ObservableCollection<Character>
            {
                new Character
                {
                    FirstName = "Finn",
                    LastName = "Mertens",
                    ImageURL = "https://vignette2.wikia.nocookie.net/deathbattlefanon/images/3/3c/Finn_the_Human.png/revision/latest?cb=20150406142522"
                },
                new Character
                {
                    FirstName = "Jacke",
                    LastName = "The Dog",
                    ImageURL = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.AjcWKfA4zLFCUs6nDmQjfQHaKs%26pid%3DApi&f=1"
                },
                new Character
                {
                    FirstName = "Bonnibel",
                    LastName = "Bubblegum",
                    ImageURL = "https://static.wikia.nocookie.net/adventuretimewithfinnandjake/images/0/00/Princess_Bubblegum.png/revision/latest/scale-to-width-down/175?cb=20190807133134"
                }
            };
        }

        private async void TabCharacter(object sender, ItemTappedEventArgs e)
        {
            Character character = e.Item as Character;
            await Navigation.PushAsync(new Detail(character));
        }

        private async void AddCharacter(object sender, EventArgs e)
        {
            Character character = new Character();
            string firstName = await DisplayPromptAsync("Vul een voornaam in", "");
            string lastName = await DisplayPromptAsync("Vul een achternaam in", "");
            character.FirstName = firstName;
            character.LastName = lastName;

            _characters.Add(character);
        }

        private void RemoveCharacter(object sender, EventArgs e)
        {
            ImageButton button = sender as ImageButton;
            var character = button.CommandParameter as Character;

            _characters.Remove(character); // geeft het object mee en cast het naar een character
        }

        private void SetFavoriteCharacter(object sender, EventArgs e)
        {
            Button button = sender as Button;
            Character favoriteCharacter = button.CommandParameter as Character; // vergeet niet in XAML: CommandParameter="{Binding .}

            //Preferences.Set("FavoriteCharacter", character.FullName); // dit doet hetzelfde
            if (_favoriteCharacter != null)
            {
                _favoriteCharacter.IsFavorite = false;
            }
            _favoriteCharacter = favoriteCharacter;
            _favoriteCharacter.IsFavorite = true;
            File.WriteAllText(_favoriteCharacterFile, $"{_favoriteCharacter.FirstName};{_favoriteCharacter.LastName}");
        }
    }
}