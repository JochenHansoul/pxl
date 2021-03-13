using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Text;

namespace AdventureTime.Models
{
    public class Character: INotifyPropertyChanged
    {
        public int Id { get; set; }
        private string _firstName;
        private string _lastName;
        private bool _isFavorite = false;
        public string ImageURL { get; set; }
        public event PropertyChangedEventHandler PropertyChanged;
        public string FirstName
        {
            get => _firstName;
            set
            {
                _firstName = value;
                SendEvent(nameof(FirstName));
            }
        }
        public string LastName
        {
            get => _lastName;
            set
            {
                _lastName = value;
                SendEvent(nameof(LastName));
            }
        }
        public string FullName
        {
            get
            {
                return $"{_firstName} {_lastName}";
            }
        }
        public bool IsFavorite
        {
            get => _isFavorite;
            set
            {
                _isFavorite = value;
                SendEvent(nameof(IsFavorite));
            }
        }

        //Hij gebruikt de naam RaisedEventPropertyChanged voor SendEvent
        public void SendEvent(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
