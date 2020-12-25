using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercise02_DisplayAmplifier
{
    class Amplifier
    {
        private double minimumValue;
        private double maximumValue;

        public Amplifier(double minimum, double maximum)
        {
            minimumValue = minimum;
            maximumValue = maximum;
        }

        // properties
        public double MinimumValue
        {
            get => minimumValue;
            set => minimumValue = value;
        }

        public double MaximumValue
        {
            get => maximumValue;
            set => maximumValue = value;
        }

        // methoden
        public double GetNewValue()
        {
            return MaximumValue - minimumValue;
        }
    }
}
