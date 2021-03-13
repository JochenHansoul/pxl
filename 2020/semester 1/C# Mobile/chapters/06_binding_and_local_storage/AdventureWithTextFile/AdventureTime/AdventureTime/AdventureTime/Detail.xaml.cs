using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AdventureTime.Models;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AdventureTime
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Detail : ContentPage
    {
        private bool _notDebugged;
        private Character _character;
        public Detail(Character character)
        {
            InitializeComponent();

            _notDebugged = true;
            _character = character;
            BindingContext = character; // zet de pagina default op dit object
        }

        private void DoSomeDebugging(object sender, EventArgs e)
        {
            if (_notDebugged)
            {
                _character.FirstName = $"Awsome {_character.FirstName}";
                // veranderd de naam zowel in de achtergrond en in de voorgrond in Awesome Finn
                _notDebugged = false;
            }
        }
    }
}