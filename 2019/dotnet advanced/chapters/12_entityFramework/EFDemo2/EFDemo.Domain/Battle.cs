using System;
using System.Collections.Generic;

namespace EFDemo.Domain
{
    public class Battle
    {
        public Battle()
        {
            SamuraiBattles = new List<SamuraiBattle>();
        }

        public int Id { get; set; }

        public string Name { get; set; }

        public DateTime StartDate { get; set; }

        public DateTime EndDate { get; set; }

        // List<Samurai> omzettten naar List<SamuraiBattle> voor een many to many ralatie
        public List<SamuraiBattle> SamuraiBattles { get; set; }
    }
}