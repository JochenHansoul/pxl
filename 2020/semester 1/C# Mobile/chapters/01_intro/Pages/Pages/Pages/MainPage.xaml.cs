using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace Pages
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private async void NavigateToNewListViewPage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new NewListViewPage());
        }

        private async void NavigateToNewContentPage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new NewContentPage());
        }
    }
}
