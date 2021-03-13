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
        private string _charactersFile;
        private string _favoriteCharacterFile;

        private ObservableCollection<Character> _characters;
        private int _lastCharacterId;
        private int _favoriteCharacterId;

        public Characters()
        {
            InitializeComponent();

            _charactersFile = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "characters.txt");
            _favoriteCharacterFile = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "favorite_characters.txt");

            _characters = GetAllCharacters();
            _lastCharacterId = (_characters.Count == 0) ? 0 : _characters[_characters.Count - 1].Id;
            //File.WriteAllText(_favoriteCharacterFile, "0");
            _favoriteCharacterId = (File.Exists(_favoriteCharacterFile)) ? Convert.ToInt32(File.ReadAllText(_favoriteCharacterFile).Split(';')[0]) : 0;
            if (_favoriteCharacterId != 0)
            {
                //_characters.FirstOrDefault(o => o.Id == _favoriteCharacterId).IsFavorite = true;
            }
            charactersListView.ItemsSource = _characters; //moet ItemSource en niet BindingSource zijn!
        }

        private ObservableCollection<Character> GetAllCharacters()
        {
            File.AppendAllText(_charactersFile, "1;Finn;Mertens;https://vignette2.wikia.nocookie.net/deathbattlefanon/images/3/3c/Finn_the_Human.png/revision/latest?cb=20150406142522");
            File.AppendAllText(_charactersFile, "2;Jake;The Dog;https://vignette2.wikia.nocookie.net/deathbattlefanon/images/3/3c/Finn_the_Human.png/revision/latest?cb=20150406142522");
            if (File.Exists(_charactersFile))
            {
                /*var characters = new ObservableCollection<Character>();
                using (StringReader reader = new StringReader(_charactersFile))
                {
                    string line;
                    while ((line = reader.ReadLine()) != null)
                    {
                        string[] characterInfo = line.Split(';');
                        if (characterInfo.Length > 1)
                        {
                            var character = new Character();
                            character.Id = Convert.ToInt32(characterInfo[0]);
                            character.FirstName = characterInfo[1];
                            character.LastName = characterInfo[2];
                            if (characterInfo.Length > 2)
                            {
                                character.ImageURL = characterInfo[3];
                            }
                            characters.Add(character);
                        }
                    }
                }
                return characters;*/

                var characters = new ObservableCollection<Character>();
                var lines = File.ReadLines(_charactersFile);
                var list = lines.ToList();
                amountOfCharactersLabel.Text = "" + list.Count();
                foreach (string line in list)
                {
                    string[] characterInfo = line.Split(';');
                    var character = new Character();
                    character.Id = Convert.ToInt32(characterInfo[0]);
                    character.FirstName = characterInfo[1];
                    character.LastName = characterInfo[2];
                    if (characterInfo.Length > 2)
                    {
                        character.ImageURL = characterInfo[3];
                    }
                    characters.Add(character);
                }
                return characters;
            }
            else
            {
                return new ObservableCollection<Character>();
            }
        }

        private async void TabCharacter(object sender, ItemTappedEventArgs e)
        {
            Character character = e.Item as Character;
            await Navigation.PushAsync(new Detail(character));
        }

        private async void AddCharacter(object sender, EventArgs e)
        {
            string firstName = await DisplayPromptAsync("Vul een voornaam in", "");
            while (firstName == "" || firstName.Contains(';'))
            {
                firstName = await DisplayPromptAsync("Vul een voornaam in", "");
            }
            string lastName = await DisplayPromptAsync("Vul een achternaam in", "");
            while (lastName == "" || lastName.Contains(';'))
            {
                lastName = await DisplayPromptAsync("Vul een achternaam naam in", "");
            }
            string imageURL = await DisplayPromptAsync("Vul een url in", "");
            while (imageURL.Contains(';'))
            {
                imageURL = await DisplayPromptAsync("Vul een url in", "");
            }

            var character = new Character();
            character.Id = ++_lastCharacterId;
            character.FirstName = firstName;
            character.LastName = lastName;
            if (imageURL == "")
            {
                File.WriteAllText(_charactersFile, $"{character.Id};{firstName};{lastName}");
            }
            else
            {
                character.ImageURL = imageURL;
                File.WriteAllText(_charactersFile, $"{character.Id};{firstName};{lastName};{imageURL}");
            }
            _characters.Add(character);
        }

        private void RemoveCharacter(object sender, EventArgs e)
        {
            ImageButton button = sender as ImageButton;
            Character character = button.CommandParameter as Character;

            var tempFile = Path.GetTempFileName();
            var linesToKeep = File.ReadLines(_charactersFile).Where(l => l.Split(';')[0] != "" + character.Id);
            File.WriteAllLines(tempFile, linesToKeep);
            File.Delete(_charactersFile);
            File.Move(tempFile, _charactersFile);

            _characters.Remove(character); // geeft het object mee en cast het naar een character
        }

        private void SetFavoriteCharacter(object sender, EventArgs e)
        {
            Button button = sender as Button;
            int favoriteCharacterId = (int) button.CommandParameter; // vergeet niet in XAML: CommandParameter="{Binding .}

            //Preferences.Set("FavoriteCharacter", character.FullName); // dit doet hetzelfde
            if (_favoriteCharacterId == 0)
            {
                _favoriteCharacterId = favoriteCharacterId;
            }
            else if (_favoriteCharacterId != favoriteCharacterId)
            {
                _characters.FirstOrDefault(o => o.Id == _favoriteCharacterId).IsFavorite = false;
                _favoriteCharacterId = favoriteCharacterId;
            }
            _characters.FirstOrDefault(o => o.Id == _favoriteCharacterId).IsFavorite = true;
            File.WriteAllText(_favoriteCharacterFile, $"{_favoriteCharacterId}");
        }
    }
}