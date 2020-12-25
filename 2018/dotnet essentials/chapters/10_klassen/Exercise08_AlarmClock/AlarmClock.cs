using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Threading;

namespace Exercise08_AlarmClock
{
    class AlarmClock
    {
        private DateTime _alarmTime = DateTime.MaxValue;
        private int _beepTimeInSeconds;

        public AlarmClock(int alarmLength = 10)
        {
            _beepTimeInSeconds = alarmLength;
        }

        public AlarmClock(DateTime alarmTime, int alarmLength = 10)
        {
            _alarmTime = alarmTime;
            _beepTimeInSeconds = alarmLength;
        }

        public string CurrentTime
        {
            get => DateTime.Now.ToString("HH:mm:ss");//.DateTime.Now.ToLongString();
        }

        public string AlarmTime
        {
            set => _alarmTime = Convert.ToDateTime(value);
        }

        public bool IsAlarmPassed()
        {
            return DateTime.Now >= _alarmTime;
        }

        public bool ShouldStopBeeping()
        {
            return IsAlarmPassed() ? _alarmTime.AddSeconds(_beepTimeInSeconds) < DateTime.Now : false; //geeft een true alleen als alarm moet stoppen
        }

        public void Reset()
        {
            _alarmTime = DateTime.MaxValue;
        }
    }
}
