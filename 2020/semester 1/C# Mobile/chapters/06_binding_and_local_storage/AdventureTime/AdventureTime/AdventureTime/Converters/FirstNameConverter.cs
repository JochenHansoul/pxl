using System;
using System.Collections.Generic;
using System.Globalization;
using System.Text;
using Xamarin.Forms;

namespace AdventureTime.Converters
{
    public class FirstNameConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            string originalFirstName = value as string;
            return originalFirstName + "!!!";
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            string v = value as string;
            return v.Substring(0, v.Length - 3);
        }
    }
}
