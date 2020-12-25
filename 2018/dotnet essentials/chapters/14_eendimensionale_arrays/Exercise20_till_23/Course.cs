using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercise20_till_23
{
    class Course
    {
        public Course(string name, string teacher, int hours)
        {
            Name = name;
            Teacher = teacher;
            Hours = hours;
        }

        // autoproperties
        public string Name { get; set; }
        public string Teacher { get; set; }
        public int Hours { get; set; }
    }
}
