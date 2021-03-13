using System.ComponentModel;
using SQLite;

namespace AdventureTime.Models
{
    public class Character: INotifyPropertyChanged
    {
        [PrimaryKey, AutoIncrement] // voor locale database
        public int ID { get; set; }
        public event PropertyChangedEventHandler PropertyChanged;
        private bool _isFavorite = false;
        private string _firstName;
        private string _lastName;
        private string _imageURL;
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

        public string ImageURL
        {
            get => _imageURL;
            set
            {
                _imageURL = value;
                SendEvent(nameof(ImageURL));
            }
        }

        //Hij gebruikt de naam RaisedEventPropertyChanged voor SendEvent
        public void SendEvent(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
