﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EFDemo.Domain
{
    public class SamuraiBattle
    {
        // ik vermoed dat dit is om de mapping tussen Samurai en Battle te veranderen
        // zodat Samurai en Battle een many to many relatie is
        public Samurai Samurai { get; set; }
        public int SamuraiId { get; set; }

        public Battle Battle { get; set; }
        public int BattleId { get; set; }
    }
}
