using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Text;
using System.Windows.Input;
using AdventureTime.Models;
using Plugin.Media;
using Xamarin.Forms;

namespace AdventureTime.Views
{
    public class CharacterDetailViewModel : INotifyPropertyChanged
    {
        private Character _character;
        public Character Character
        {
            get { return _character; }
            set
            {
                _character = value;
                RaisedChangedEvent(nameof(Character));
            }
        }
        public ICommand TakePictureCommand { get; }
        public ICommand SaveCharacter { get; }
        public CharacterDetailViewModel()
        {
            TakePictureCommand = new Command(OnTakePicture);
        }

        private async void OnTakePicture(object obj)
        {
            await CrossMedia.Current.Initialize();

            if (!CrossMedia.Current.IsCameraAvailable || !CrossMedia.Current.IsTakePhotoSupported)
            {
                //_ = DisplayAlert("No Camera", ":( No camera available.", "OK");
                return;
            }

            var file = await CrossMedia.Current.TakePhotoAsync(new Plugin.Media.Abstractions.StoreCameraMediaOptions
            {
                Directory = "Sample",
                Name = "test.jpg"
            });

            if (file == null)
                return;

            //await DisplayAlert("File Location", file.Path, "OK");

            _character.ImageURL = file.Path; // plaatst links naar bestand
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public void  RaisedChangedEvent(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
