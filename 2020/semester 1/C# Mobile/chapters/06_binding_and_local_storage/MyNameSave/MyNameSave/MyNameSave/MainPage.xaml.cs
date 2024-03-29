﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace MyNameSave
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private async void GoToEnterNamePage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new EnterNamePage());
        }

        private async void GoToShowNamePage(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new ShowNamePage());
        }
    }
}
