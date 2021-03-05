using System;
using System.Collections.Generic;
using System.Linq;
using LinqExamples.Models;

namespace LinqExamples
{
    public class OrderByExamples
    {
        public int[] SortNumbersDescending(int[] numbers)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToArray" extension method to convert an IEnumerable to an Array
            var sortedNumbers = from number in numbers
                                orderby number descending
                                select number;
            return sortedNumbers.ToArray();
        }

        public IList<Person> SortPersonsOnDescendingAgeAndThenOnDescendingName(List<Person> persons)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToList" extension method to convert an IEnumerable to a List
            var sortedPersons = from person in persons
                                orderby person.Age descending, person.Name descending
                                select person;
            return sortedPersons.ToList();
        }
    }
}