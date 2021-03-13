using System;
using System.Collections.Generic;
using System.Globalization;
using System.Text;
using Xamarin.Forms;

namespace AdventureTime.Converters
{
    public class LastNameToColorConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            string name = value as string;
            int length = name.Length;
            if (length < 5)
            {
                return Color.Red;
            }
            else if (length < 10)
            {
                return Color.Orange;
            }
            else
            {
                return Color.Green;
            }
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException(); // should normally not enter this method
        }
    }
}
