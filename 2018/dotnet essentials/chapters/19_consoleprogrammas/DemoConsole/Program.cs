using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Please enter your name:");
            string name = Console.ReadLine();
            Console.WriteLine($"Hi there {name}");
            string wait = Console.ReadLine(); // bij gezet voor ons zodat duidelijk is dat moet wachten
        }
    }
}
