using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace RedDevils
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class HomePage : ContentPage
    {
        public HomePage()
        {
            InitializeComponent();
        }

        private async void NavigateToTeamPage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new TeamPage());
        }

        private async void NavigateToSettingsPage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new SettingsPage());
        }

        private async void NavigateToAboutPage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new AboutPage());
        }
    }
}