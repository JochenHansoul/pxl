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
    public partial class TeamPage : ContentPage
    {
        public TeamPage()
        {
            InitializeComponent();

            redDevilsListView.ItemsSource = new List<Player>
            {
                new Player
                {
                    FirstName = "Hendrik",
                    LastName = "Van Crombrugge",
                    ImageURL = "https://assets.sorare.com/seasonpicture/1c529eae-f9bf-47aa-9af5-a11a909b5c6a/picture/trimmed-747b44cf1926f07f9630387e74babb02.png"
                },
                new Player
                {
                    FirstName = "Thibout",
                    LastName = "Courtois",
                    ImageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Courtois_aug_2014.jpg/1200px-Courtois_aug_2014.jpg"
                },
                new Player
                {
                    FirstName = "Koen",
                    LastName = "Kasteels",
                    ImageURL = "https://www.soccerrich.com/wp-content/uploads/2018/09/Koen-Casteels.jpg"
                }
            };
        }

        private async void SelectPlayer(object sender, ItemTappedEventArgs e)
        {
            Player player = e.Item as Player;
            await Navigation.PushAsync(new PlayerDetailPage(player));
        }
    }
}