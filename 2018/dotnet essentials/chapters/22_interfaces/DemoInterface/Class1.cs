using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoInterface
{
    class Class1 : Interface1
    {
        private int _memberVar; // memvervariabelen altijd beginnen met underscore
        public int Prop { get => _memberVar/*throw new NotImplementedException()*/; set => _memberVar = value/*throw new NotImplementedException()*/; }

        public int Method1()
        {
            /*throw new NotImplementedException() dit wegdoen*/;
            return 0; //////////////// dit moet nog aangepast worden!
        }

        public void Method2()
        {
            /*throw new NotImplementedException();*/
        }
    }
}
