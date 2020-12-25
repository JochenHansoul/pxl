using System;
using System.Collections.Generic;
using System.Linq;
using System.Media;
using System.Text;
using System.Threading.Tasks;

namespace Exercise07_AlarmClock
{
    public class BeeperAlarmClock : AlarmClock
    {
        private SystemSound sound = SystemSounds.Beep;

        // constructors
        public BeeperAlarmClock() : base() { }

        public BeeperAlarmClock(DateTime alarmTime) : base(alarmTime) { }

        // methods
        public void Beeping()
        {
            sound.Play();
        }
    }
}
