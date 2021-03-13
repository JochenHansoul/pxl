using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace ActorList
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class ActorDetail : ContentPage
    {
        public ActorDetail(Actor actor)
        {
            InitializeComponent();

            actorLabel.Text = actor.ToString();
            actorImage.Source = actor.PhotoURL;
        }
    }
}