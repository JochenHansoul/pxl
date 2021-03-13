using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AdventureTime.Models;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AdventureTime
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class FavoriteCharacter : ContentPage
    {
        private string _charactersFile;
        private string _favoriteCharacterFile;
        public FavoriteCharacter()
        {
            InitializeComponent();

            _charactersFile = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "characters.txt");
            _favoriteCharacterFile = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "favorite_characters.txt");

            var favoriteCharacter = GetFavoriteCharacter();
            favoriteCharacterLabel.Text = (favoriteCharacter != null)
                ? $"{favoriteCharacter.FirstName} {favoriteCharacter.LastName}"
                : "No favorite character selected";
        }
        
        private Character GetFavoriteCharacter()
        {
            if (File.Exists(_charactersFile) && File.Exists(_favoriteCharacterFile))
            {
                var characters = new List<Character>();
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
                int favoriteCharacterId = Convert.ToInt32(File.ReadAllText(_favoriteCharacterFile));
                return characters.FirstOrDefault(o => o.Id == favoriteCharacterId);
            }
            else
            {
                return null;
            }
        }
    }
}