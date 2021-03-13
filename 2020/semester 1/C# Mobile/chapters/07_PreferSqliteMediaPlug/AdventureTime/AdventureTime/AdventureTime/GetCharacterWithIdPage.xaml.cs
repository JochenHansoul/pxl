using System;
using AdventureTime.Models;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AdventureTime
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class GetCharacterWithIdPage : ContentPage
    {
        public GetCharacterWithIdPage()
        {
            InitializeComponent();
        }

        private async void GetCharacterWithId(object sender, EventArgs e)
        {
            Character character = await App.Database.GetCharacterWithIdAsync(Convert.ToInt32(idEntry.Text));
            fullNameLabel.Text = (character != null) ? character.FullName : "Is null";
        }

        // de IDE veranderde void naar Task en voegde automatisch Async toe
        //private async Task GetCharacterWithIdAsync(int id)
        //{
        //    Character character = await App.Database.GetCharacterWithIdAsync(id);
        //    fullNameLabel.Text = (character != null) ? character.FullName : "Is null";
        //}
    }
}