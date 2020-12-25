using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EFDemo.Domain;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Console;

namespace EFDemo.Data
{
    public class SamuraiContext: DbContext
    {
        // van pluralsight
        public static readonly LoggerFactory MyConsoleLoggerFactory
            = new LoggerFactory(new[]
            {
                new ConsoleLoggerProvider((category, level) =>
                category == DbLoggerCategory.Database.Command.Name &&
                level == LogLevel.Information, true)
            });
        // commands used on db wil be output on data window
        //var consoleLoggerProvider = new ConsoleLoggerProvider(
        //    filter: (category, level) =>
        //        category == DbLoggerCategory.Database.Command.Name &&
        //        level == LogLevel.Information,
        //        includeScopes:true);

        //var loggerFactory = new LoggerFactory(providers: new ILoggerProvider[]
        //{
        //    consoleLoggerProvider
        //});

        public DbSet<Samurai> Samurais { get; set; }
        public DbSet<Quote> Quotes { get; set; }
        public DbSet<Battle> Battles { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder
                .UseLoggerFactory(MyConsoleLoggerFactory)
                .EnableSensitiveDataLogging(true)
                .UseSqlServer(
                "Server=(localdb)\\mssqllocaldb; " +
                "Database = EFDemo3DB; " +
                "Trusted_Connection = True;"); //EFDemo3D8 veranderen in naam van uw database
        }

        //voor many to many mapping Battle en Samurai
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<SamuraiBattle>()
                .HasKey(s => new {s.BattleId, s.SamuraiId});
        }
    }

}
