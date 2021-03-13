using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Text;
using AdventureTime.Models;

namespace AdventureTime.ViewModels
{
    public class CharactersViewModel : INotifyPropertyChanged
    {
        public Characters[] GetCharacters { get; }

        public event PropertyChangedEventHandler PropertyChanged;

        public void AddCharacter()
        {
            Character character = new Character();
            //string firstName = await DisplayPromptAsync("Vul een voornaam in", "");
            //string lastName = await DisplayPromptAsync("Vul een achternaam in", "");
            //character.FirstName = firstName;
            //character.LastName = lastName;

            //await App.Database.SaveCharacterAsync(character);
            //charactersListView.ItemsSource = await App.Database.GetCharactersAsync();
        }

        public void RemoveCharacter()
        {
            //ImageButton button = sender as ImageButton;
            //var character = button.CommandParameter as Character;

            //await App.Database.DeleteCharacterAsync(character);
            //charactersListView.ItemsSource = await App.Database.GetCharactersAsync();
        }


    }
}
