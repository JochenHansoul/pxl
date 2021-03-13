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
    public partial class LoginPage : ContentPage
    {
        public LoginPage()
        {
            InitializeComponent();
        }

        private async void NavigateToHomePage(object sender, EventArgs e)
        {
            if (usernameEntry.Text != null && passportEntry.Text != null)
            {
                // de if werkt nog niet helemaal
                await Navigation.PushAsync(new HomePage());
            }
            else
            {
                errorLabel.Text = "Must fill in name and password";
            }
        }
    }
}