using System;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;

namespace PasswordApp.Data
{
    public class PasswordDbContext : DbContext
    {
        private readonly PasswordDbContext _context;
        public PasswordDbContext(DbContextOptions<PasswordDbContext> options)
            : base(options)
        {
            _context = options;
        }

        public void Add(Entry entry, User user, Role role)
        {
            _context.Add(entry, user, role);
        }
    }
}
