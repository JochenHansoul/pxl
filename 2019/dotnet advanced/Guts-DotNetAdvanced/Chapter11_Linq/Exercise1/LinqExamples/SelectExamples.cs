using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using LinqExamples.Models;

namespace LinqExamples
{
    public class SelectExamples
    {
        public IList<double> RoundDoublesUsingProjection(IEnumerable<double> doubles)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToList" extension method to convert an IEnumerable to a List
            var roundedNumbers = from number in doubles
                                 select Math.Round(number);
            return roundedNumbers.ToList<double>();
        }

        public IList<AngleInfo> ConvertAnglesToAngleInfos(IEnumerable<double> anglesInDegrees)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToList" extension method to convert an IEnumerable to a List
            var anglesInfos = from number in anglesInDegrees
                         select new AngleInfo { Angle = number, Cosinus = Math.Cos(number * Math.PI / 180), Sinus = Math.Sin(number * Math.PI / 180) };
            return anglesInfos.ToList<AngleInfo>();
        }
    }
}
