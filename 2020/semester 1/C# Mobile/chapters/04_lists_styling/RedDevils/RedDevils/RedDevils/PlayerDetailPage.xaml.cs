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
    public partial class PlayerDetailPage : ContentPage
    {
        public PlayerDetailPage(Player player)
        {
            InitializeComponent();

            //playerName.Text = player.FullName.ToString();
            playerStackLayout.BindingContext = player;
        }
    }
}