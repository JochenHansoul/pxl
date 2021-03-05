using System;
using System.Globalization;
using System.Windows.Data;

namespace NumberConverter.UI.Converters
{
    public class RomanNumberConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            int number = (int)value;
            string result = "";
            if (number < 1 && number > 3999) throw new ArgumentNullException("Out of Roman Range (1-3999)");
            while (number >= 1000)
            {
                result += "M";
                number -= 1000;
            }
            if (number >= 900)
            {
                result += "CM";
                number -= 900;
            }
            if (number >= 500)
            {
                result += "D";
                number -= 500;
            }
            while (number >= 100)
            {
                result += "C";
                number -= 100;
            }
            if(number >= 90)
            {
                result += "XC";
                number -= 90;
            }
            if(number >= 50)
            {
                result += "L";
                number -= 50;
            }
            if(number >= 40)
            {
                result += "XL";
                number -= 40;
            }
            while(number >= 10)
            {
                result += "x";
                number -= 10;
            }
            if(number >= 5)
            {
                result += "V";
                number -= 5;
            }
            //if(number )
            return result;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
