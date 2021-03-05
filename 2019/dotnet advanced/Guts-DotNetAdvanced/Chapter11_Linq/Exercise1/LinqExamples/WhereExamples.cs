using System;
using System.Collections.Generic;
using System.Linq;
using LinqExamples.Models;

namespace LinqExamples
{
    public class WhereExamples
    {
        public int[] FilterOutNumbersDivisibleByFive(int[] numbers)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToArray" extension method to convert an IEnumerable to an Array
            var filteredNumbers = from number in numbers
                                  where number % 5 == 0
                                  select number;
            return filteredNumbers.ToArray();
        }

        public IList<Person> FilterOutPersonsThatAreEighteenOrOlder(List<Person> persons)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToList" extension method to convert an IEnumerable to a List
            var filteredPersons = from person in persons
                                  where person.Age >= 18
                                  select person;
            return filteredPersons.ToList<Person>();
        }
    }
}