using System;
using Xamarin.Forms;

namespace AdventureTime
{
    public partial class MainPage : ContentPage
    {
        private ContentPage _characterListPage;

        public MainPage()
        {
            InitializeComponent();

            _characterListPage = new Characters();
            // zonder dit wordt heel de pagine gepopt en opnieuw aangemaakt
            // alles in intern geheugen bewaard
        }

        private async void NavigateToCharacters(object sender, EventArgs e)
        {
            await Navigation.PushAsync(_characterListPage);
        }

        private async void NavigateToFavoriteCharacter(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new FavoriteCharacter());
        }

        private async void NavigateToGetCharacterWithIdPage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new GetCharacterWithIdPage());
        }
    }
}
