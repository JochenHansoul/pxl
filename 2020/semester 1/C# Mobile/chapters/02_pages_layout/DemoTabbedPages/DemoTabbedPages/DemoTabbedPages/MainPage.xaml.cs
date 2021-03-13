using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DemoTabbedPages.Helpers; // dit moest erbij anders kon ik new Contact() niet gebruiken
using Xamarin.Forms;

namespace DemoTabbedPages
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private async void NavigateToContact(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new Contact());
        }

        private async void NavigateToHome(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new Home());
        }

        private async void NavigateToRestaurant(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new Restaurant());
        }

        //private async void GoToContact(object sender, SelectedItemChangedEventArgs e)
        //{
        //    /*if (e.SelectedItem != null)
        //    {
        //        Actor actor = e.SelectedItem as Actor;
        //        await Navigation.PushAsync(new ActorDetail(actor));
        //        actorListView.SelectedItem = null; // trucje om te resetten
        //    }*/
        //    await Navigation.PushAsync(new Contact());
        //}
    }
}
