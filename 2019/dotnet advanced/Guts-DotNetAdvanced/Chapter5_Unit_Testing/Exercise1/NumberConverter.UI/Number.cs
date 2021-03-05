namespace NumberConverter.UI
{
    public class Number
    {
        public Number(int value)
        {
            var conv = new Converters.RomanNumberConverter();
            var newVar = conv.Convert(value, NumberAsText, parameter:async);
            NumberAsText = value.ToString();
        }
        public string NumberAsText { get; set; }
    }
}