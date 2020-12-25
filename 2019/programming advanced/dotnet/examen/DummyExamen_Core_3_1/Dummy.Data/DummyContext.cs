using System;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;

namespace Dummy.Data
{
    public class DummyContext : IdentityDbContext<IdentityUser>
    {
        public DummyContext(DbContextOptions options) : base(options)
        {

        }
    }
}
