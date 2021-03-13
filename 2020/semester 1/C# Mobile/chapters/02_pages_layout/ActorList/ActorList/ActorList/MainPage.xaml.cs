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

            AddActorsToList();
        }

        private void AddActorsToList()
        {
            actorListView.ItemsSource = new List<Actor>
            {
                new Actor
                {
                    Name = "Tom Hanks",
                    MovieName = "Forrest Gumb",
                    PhotoURL = "https://cdn-img.instyle.com/sites/default/files/styles/684xflex/public/1470767453/080916-Tom-Hanks-Mansion-LEAD.jpg?itok=zjFzr5Tb"
                },
                new Actor
                {
                    Name = "Angelina Jolie",
                    MovieName = "Tomb Raider",
                    PhotoURL = "https://celebmafia.com/wp-content/uploads/2018/01/angelina-jolie-the-national-board-of-review-annual-awards-gala-in-nyc-12.jpg"
                },
                new Actor
                {
                    Name = "Shaun Connerys",
                    MovieName = "James Bond",
                    PhotoURL="https://academiaparaninfo.files.wordpress.com/2015/08/sean-connery-09.jpg"
                },
            };
            // zonder binding gaat automatisch de ToString() methode gebruiken
            // meestal wel lijsten niet gehardcoded in C# maar gehaald uit database
        }

        private void SelectActor(object sender, SelectedItemChangedEventArgs e)
        {
            Actor actor = e.SelectedItem as Actor;
            Navigation.PushAsync(new ActorDetail(actor));
        }
    }
}
