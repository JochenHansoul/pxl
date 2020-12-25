using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OefeningDog
{
    public class Animal
    {
        protected string _name;

        public Animal()
        {
            _name = "Default animal name";
        }
        public Animal(string name)
        {
            _name = name;
        }

        public virtual string Sound()
        {
            return "Huh?";
        }

        public string Name
        {
            get => _name;
            set => _name = value;
        }
    }
}
