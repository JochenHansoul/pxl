using System;
using System.Collections.Generic;
using System.Linq;
using LinqExamples.Models;

namespace LinqExamples
{
    public class GroupExamples
    {
        public IList<IGrouping<int, int>> GroupEvenAndOddNumbers(int[] numbers)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToList" extension method to convert an IEnumerable to a List
            var evenAndOddNumbers = from number in numbers
                                    group number by number % 2;
            return evenAndOddNumbers.ToList();
        }

        public IList<PersonAgeGroup> GroupPersonsByAge(List<Person> persons)
        {
            //throw new NotImplementedException();
            //Tip: use the "ToList" extension method to convert an IEnumerable to a List
            var groupedPersons = from person in persons
                                 group person by person.Age into ages
                                 select new PersonAgeGroup
                                 {
                                     Age = ages.Key,
                                     Persons = ages.ToList() //de .ToList() moet er niets eens staan
                                 };
            return groupedPersons.ToList();
        }
    }
}