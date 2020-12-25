using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OefeningDog
{
    public class SmallDog : Dog
    {
        public SmallDog(string name) : base(name)
        {
            _name = name;
        }

        public override string Sound()
        {
            return "Kef kef";
        }
    }
}
