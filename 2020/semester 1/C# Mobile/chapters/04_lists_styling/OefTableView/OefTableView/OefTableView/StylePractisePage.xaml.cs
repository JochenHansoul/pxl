using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace OefTableView
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class StylePractisePage : ContentPage
    {
        public StylePractisePage()
        {
            InitializeComponent();
        }

        private async void GoToSettingsPage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new SettingsPage());
        }
    }
}