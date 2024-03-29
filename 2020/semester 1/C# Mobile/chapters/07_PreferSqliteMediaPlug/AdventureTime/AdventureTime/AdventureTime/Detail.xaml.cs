﻿using System;
using AdventureTime.Models;
using Plugin.Media;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AdventureTime
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Detail : ContentPage
    {
        //private bool _notDebugged;
        private Character _character;
        public Detail(Character character)
        {
            InitializeComponent();

            //_notDebugged = true;
            _character = character;
            BindingContext = _character; // zet de pagina default op dit object

            takePhotoButton.Clicked += async (sender, args) =>
            {
                await CrossMedia.Current.Initialize();

                if (!CrossMedia.Current.IsCameraAvailable || !CrossMedia.Current.IsTakePhotoSupported)
                {
                    _ = DisplayAlert("No Camera", ":( No camera available.", "OK");
                    return;
                }

                var file = await CrossMedia.Current.TakePhotoAsync(new Plugin.Media.Abstractions.StoreCameraMediaOptions
                {
                    Directory = "Sample",
                    Name = "test.jpg"
                });

                if (file == null)
                    return;

                await DisplayAlert("File Location", file.Path, "OK");

                _character.ImageURL = file.Path; // plaatst links naar bestand

                // stond bij gecompieerd bestand
                //image.Source = ImageSource.FromStream(() =>
                //{
                //    var stream = file.GetStream();
                //    return stream;
                //});
            };
        }

        /*private void DoSomeDebugging(object sender, EventArgs e)
        {
            if (_notDebugged)
            {
                _character.FirstName = $"Awsome {_character.FirstName}";
                // veranderd de naam zowel in de achtergrond en in de voorgrond in Awesome Finn
                _notDebugged = false;
            }
        }*/

        private async void SaveCharacter(object sender, EventArgs e)
        {
            await App.Database.SaveCharacterAsync(_character);
        }
    }
}