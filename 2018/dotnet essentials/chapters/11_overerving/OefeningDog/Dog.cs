using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OefeningDog
{
    public class Dog : Animal
    {
        public Dog(int something)
        {
            _name = "standard dog name";
        }
        public Dog(string name) : base(name)
        {
            _name = name;
        }

        public override string Sound()
        {
            return "Woef Woef";
        }
    }
}
