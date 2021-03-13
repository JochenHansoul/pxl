using System;
using System.Collections.Generic;
using System.Linq;
using AdventureTime.Models;
using AdventureTime.Views;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AdventureTime
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Characters : ContentPage
    {
        public Characters()
        {
            InitializeComponent();
        }

        protected override async void OnAppearing()
        {
            base.OnAppearing();
            charactersListView.ItemsSource = await App.Database.GetCharactersAsync();
        }

        private async void TabCharacter(object sender, ItemTappedEventArgs e)
        {
            Character character = e.Item as Character;

            /*CharacterDetailViewModel viewModel = new CharacterDetailViewModel();
            viewModel.Character = character;
            Detail detailPage = new Detail(character);
            detailPage.BindingContext = viewModel;*/

            await Navigation.PushAsync(new Detail(character));
        }

        private async void AddCharacter(object sender, EventArgs e)
        {
            Character character = new Character();
            string firstName = await DisplayPromptAsync("Vul een voornaam in", "");
            string lastName = await DisplayPromptAsync("Vul een achternaam in", "");
            character.FirstName = firstName;
            character.LastName = lastName;

            await App.Database.SaveCharacterAsync(character);
            charactersListView.ItemsSource = await App.Database.GetCharactersAsync();
        }

        private async void RemoveCharacter(object sender, EventArgs e)
        {
            ImageButton button = sender as ImageButton;
            var character = button.CommandParameter as Character;

            await App.Database.DeleteCharacterAsync(character);
            charactersListView.ItemsSource = await App.Database.GetCharactersAsync();
        }

        private async void SetNewFavoriteCharacter(object sender, EventArgs e)
        {
            Button button = sender as Button;
            int id = (int) button.CommandParameter;

            List<Character> characters = await App.Database.GetCharactersAsync();
            Character originalFavoriteCharacter = characters.FirstOrDefault(o => o.IsFavorite);
            if (originalFavoriteCharacter == null)
            {
                SetFavoriteCharacter(characters, id);
            }
            else if (originalFavoriteCharacter.ID != id)
            {
                UnsetFavoriteCharacter(originalFavoriteCharacter);
                SetFavoriteCharacter(characters, id);
            }
        }

        private async void UnsetFavoriteCharacter(Character character)
        {
            character.IsFavorite = false;
            await App.Database.SaveCharacterAsync(character);
        }

        private async void SetFavoriteCharacter(List<Character> characters, int id)
        {
            Character character = characters.FirstOrDefault(o => o.ID == id);
            character.IsFavorite = true;
            await App.Database.SaveCharacterAsync(character);
            charactersListView.ItemsSource = characters;
        }
    }
}