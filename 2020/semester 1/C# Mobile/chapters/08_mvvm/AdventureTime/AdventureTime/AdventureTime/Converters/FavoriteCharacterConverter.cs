using System;
using System.Globalization;
using Xamarin.Forms;

namespace AdventureTime.Converters
{
    class FavoriteCharacterConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            bool isFavorite = (bool) value;
            return isFavorite ? Color.Green : Color.Red;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
