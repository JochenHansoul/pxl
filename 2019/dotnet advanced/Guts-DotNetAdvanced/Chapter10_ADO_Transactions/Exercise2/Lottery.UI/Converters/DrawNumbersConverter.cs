using Lottery.Domain;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Windows.Data;

namespace Lottery.UI.Converters
{
    public class DrawNumbersConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            if(value is ICollection<DrawNumber>)
            {
                string result = "";
                var set = value as ICollection<DrawNumber>; //gaat casten naar hashset. Moet ICollection gebruiker voor HashSet en OrderBy
                foreach(var number in set.OrderBy(p => p.Position)) //sorteren op positie
                {
                    result += $"{ number.Number },";
                }
                return result.Remove(result.Length - 1); // removes last character
            }
            return null;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            return null;
        }
    }
}
