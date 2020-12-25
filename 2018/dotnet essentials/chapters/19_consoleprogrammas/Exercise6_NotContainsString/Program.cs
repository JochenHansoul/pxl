using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercise6_NotContainsString
{
    class Program
    {
        static void Main(string[] args)
        {
            string fileName = args[0];
            string wanted = args[1];

            // if arg != 2

            StreamReader reader = File.OpenText(fileName);
            string line = reader.ReadLine();
            while (line != null) // while (reader.Peek() >= 0) dit niet meer gedaan, kijkt eerst even of bestaat
            {
                if (!(line.IndexOf(wanted) >= 0))
                {
                    Console.WriteLine(line);
                }
                line = reader.ReadLine();
            }
            reader.Close();
            //string wait = Console.ReadLine();

            //cmd opendoen, naar debug map gaan: <naam>.exe ..\..\<naam>.txt zoekterm
            // als je het programma veranderd niet vergeten eerst te ruggen
        }
    }
}
