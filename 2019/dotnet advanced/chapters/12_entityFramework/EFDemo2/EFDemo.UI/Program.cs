using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EFDemo.Data;
using EFDemo.Domain;

namespace EFDemo.UI
{
    public class Program
    {
        private static SamuraiContext _context;

        static void Main(string[] args)
        {
            //InsertSamurai(); //moet maar 1 keer iets toevoegen. Db onthoud het.
            QuerySamurais();

            Console.Write("\nPress return to quit...");
            Console.ReadLine();
        }

        private static void QuerySamurais()
        {
            using (var _context = new SamuraiContext())
            {

                //var samurais = context.Samurais.ToList();

                // querry:
                // (we gaan geen Linq querrie uitvoeren)
                /*var query = from samurai in context.Samurais
                            select samurai;*/
                var samurais = _context.Samurais
                    .Where(s => s.Id == 10) //gaat query onmiddelijk uitvoeren
                    .ToList();

                //foreach (Samurai samurai in samurais)
                //{
                //    Console.Write($"\n{ samurai.Name }");
                //}
            }
        }

        private static void InsertSamurai()
        {
            Samurai samurai = new Samurai
            {
                Name = "Samurai1",
            };

            // door using sluit het de connectie automatisch na uitvoering
            using (SamuraiContext samuraiContext = new SamuraiContext())
            {
                samuraiContext.Samurais.Add(samurai); // .AddRange(samurai1, samurai2); voor meerdere samurais toe te voegen
                samuraiContext.SaveChanges();
            }

            // written self:
            //var quotes = new List<Quote>();
            //quotes.Add(new Quote() { Text = "Yaaaah!" });
            //var samurai1 = new Samurai()
            //{
            //    Name = "Usagi",
            //    Quotes = quotes
            //};
            //_context.Samurais.Add(samurai1); // Ik kan blijkbaar ook gewoon de SamuraiContect gebruiker
        }
    }
}
