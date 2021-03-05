using System;
using System.Collections.Generic;
using System.Linq;
using LinqExamples.Models;

namespace LinqExamples
{
    public class JoinExamples
    {
        public int[] GetIntersection(int[] firstList, int[] secondList)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToArray" extension method to convert an IEnumerable to an Array
            var sameNumbers = from number in firstList
                              join number2 in secondList on number equals number2
                              orderby number
                              select number;
            return sameNumbers.ToArray();
        }

        public IList<string> FindCouplesByAgeUsingJoin(List<Person> boys, List<Person> girls)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToList" extension method to convert an IEnumerable to a List
            var couples = from boy in boys
                          join girl in girls on boy.Age equals girl.Age
                          where boy.Age == girl.Age
                          orderby boy.Age, girl.Age
                          select boy.Name + " and " + girl.Name;
            return couples.ToList<String>();
        }
    }
}