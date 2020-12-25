using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Media;

namespace Exercise07_AlarmClock
{
    public class FlickerAlarmClock : AlarmClock
    {
        private static Color _white = Colors.White;
        private static Color _red = Colors.Tomato;
        private SolidColorBrush _brush = new SolidColorBrush(_white);

        // constructors
        public FlickerAlarmClock() : base() { }

        public FlickerAlarmClock(DateTime alarmTime) : base(alarmTime) { }

        // methods
        public void Flickering(TextBlock textBlock)
        {
            textBlock.Background = _brush;
            _brush.Color = _brush.Color == _white ? _red : _white;
        }

        public void ReturnBaseColor(TextBlock textBlock)
        {
            _brush.Color = _white;
            textBlock.Background = _brush;
        }
    }
}
