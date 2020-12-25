using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Threading;

namespace Exercise07_AlarmClock
{
    public abstract class AlarmClock
    {
        // member variables
        protected DateTime _alarmTime = DateTime.MaxValue;
        protected int _beepTimeSeconds = 11;

        public AlarmClock()
        {
        }

        public AlarmClock(DateTime alarmTime)
        {
            _alarmTime = alarmTime;
        }

        // properties
        public static string CurrentTime
        {
            get => DateTime.Now.ToString("HH:mm:ss");//.DateTime.Now.ToLongString();
        }

        public string AlarmTime
        {
            set => _alarmTime = Convert.ToDateTime(value);
        }

        // methods
        public bool IsAlarmPassed()
        {
            return DateTime.Now >= _alarmTime;
        }

        public virtual bool ShouldStopBeeping()
        {
            return IsAlarmPassed() ? _alarmTime.AddSeconds(_beepTimeSeconds) < DateTime.Now : false; //geeft een true alleen als alarm moet stoppen
        }

        public void Reset()
        {
            _alarmTime = DateTime.MaxValue;
        }
    }
}
