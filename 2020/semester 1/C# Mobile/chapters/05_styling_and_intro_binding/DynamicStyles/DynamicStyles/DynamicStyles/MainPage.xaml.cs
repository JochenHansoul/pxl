using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace DynamicStyles
{
    public partial class MainPage : ContentPage
    {
        private bool _stileAActive;
        public MainPage()
        {
            InitializeComponent();

            Resources["dynamicStyle1"] = Application.Current.Resources["styleA"];
            _stileAActive = true;
        }

        private void Switch_PropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            if (_stileAActive)
            {
                Resources["dynamicStyle1"] = Application.Current.Resources["styleB"];
                _stileAActive = false;
            }
            else
            {
                Resources["dynamicStyle1"] = Application.Current.Resources["styleA"];
                _stileAActive = true;
            }
        }
    }
}
