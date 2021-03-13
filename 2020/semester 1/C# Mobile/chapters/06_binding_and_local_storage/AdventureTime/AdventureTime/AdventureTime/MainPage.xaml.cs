using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
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
    }
}
