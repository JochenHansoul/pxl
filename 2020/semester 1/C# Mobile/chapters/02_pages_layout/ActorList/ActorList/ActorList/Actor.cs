using System;
using System.Collections.Generic;
using System.Text;

namespace ActorList
{
    public class Actor
    {
        public string Name { get; set; }
        public string MovieName { get; set; }
        public string PhotoURL { get; set; }
        public string Combined
        {
            get
            {
                return $"{Name} ({MovieName})";
            }
        }
        public override string ToString()
        {
            return $"De naam van de acteur is: {Name}";
        }
    }
}
