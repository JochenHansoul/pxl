using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace ActorList
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();

            // de lijst wordt gerefreshed wanneer naar beneden scrolt en refreshed wordt de lijst gerefreshed
            actorListView.RefreshCommand = new Command(() =>
            {
                RefreshTheList();
                actorListView.IsRefreshing = false;
            });

            AddActorsToList();
        }

        private void RefreshTheList()
        {
            actorListView.ItemsSource = new List<Actor>
            {
                new Actor
                {
                    Name = "Mel Gibson",
                    MovieName = "Bravehearth",
                    PhotoURL = "https://pixel.nymag.com/imgs/daily/vulture/2017/01/24/24-mel-gibson.w700.h700.jpg"
                }
            };
        }

        private void AddActorsToList()
        {
            actorListView.ItemsSource = new List<Actor>
            {
                new Actor
                {
                    Name = "Tom Hanks",
                    MovieName = "Forrest Gumb",
                    Age = 45,
                    PhotoURL = "https://cdn-img.instyle.com/sites/default/files/styles/684xflex/public/1470767453/080916-Tom-Hanks-Mansion-LEAD.jpg?itok=zjFzr5Tb"
                },
                new Actor
                {
                    Name = "Angelina Jolie",
                    MovieName = "Tomb Raider",
                    Age = 38,
                    PhotoURL = "https://celebmafia.com/wp-content/uploads/2018/01/angelina-jolie-the-national-board-of-review-annual-awards-gala-in-nyc-12.jpg"
                },
                new Actor
                {
                    Name = "Shaun Connerys",
                    MovieName = "James Bond",
                    Age = 58,
                    PhotoURL="https://academiaparaninfo.files.wordpress.com/2015/08/sean-connery-09.jpg"
                },
            };
            // zonder binding gaat automatisch de ToString() methode gebruiken
            // meestal wel lijsten niet gehardcoded in C# maar gehaald uit database
        }

        private async void SelectActor(object sender, SelectedItemChangedEventArgs e)
        {
            if (e.SelectedItem != null)
            {
                Actor actor = e.SelectedItem as Actor;
                await Navigation.PushAsync(new ActorDetail(actor));
                actorListView.SelectedItem = null; // trucje om te resetten
            }
        }
    }
}
