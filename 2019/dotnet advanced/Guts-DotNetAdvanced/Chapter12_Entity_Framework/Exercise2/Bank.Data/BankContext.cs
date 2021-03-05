using System;
using System.Collections.Generic;
using System.Configuration;
using Bank.Data.DomainClasses;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;

namespace Bank.Data
{
    public class BankContext : DbContext
    {
        public DbSet<City> Cities { get; set; }
        public DbSet<Customer> Customers { get; set; }
        public DbSet<Account> Accounts { get; set; }

        public BankContext() { } //Constructor used by UI

        public BankContext(DbContextOptions<BankContext> options) : base(options) { } //Constructor used by Test project

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured) //only configure the connection if the parameter-less constructor was used (no options where provided).
            {
                //TODO: tell EF (Entity Framework) that is going to operate against a SQL Server database using the connection string in the app.config of the UI project
                string connectionString = ConfigurationManager.ConnectionStrings["BankConnection"].ConnectionString;
                optionsBuilder.UseSqlServer(connectionString);
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            //aanmaken van database
            modelBuilder.Entity<City>().HasKey(c => c.ZipCode);
            modelBuilder.Entity<Account>().HasKey(c => c.Id);
            modelBuilder.Entity<Customer>().HasKey(c => c.Id);

            modelBuilder.Entity<Account>().Property(c => c.AccountNumber).IsRequired();
            modelBuilder.Entity<Customer>().Property(c => c.Name).IsRequired();
            modelBuilder.Entity<Customer>().Property(c => c.FirstName).IsRequired();

            modelBuilder.Entity<Customer>()
                .HasOne(c => c.City)
                .WithMany(cy => cy.Customers)
                .HasForeignKey(cu => cu.ZipCode);

            modelBuilder.Entity<Customer>()
                .HasMany(c => c.Accounts)
                .WithOne(a => a.Customer)
                .HasForeignKey(x => x.CustomerId);
                
            modelBuilder.Entity<City>().HasData(
                new City { Name = "Antwerpen", ZipCode = 2000 },
                new City { Name = "Leuven", ZipCode = 3000 },
                new City { Name = "Hasselt", ZipCode = 3500 },
                new City { Name = "Brugge", ZipCode = 8000 },
                new City { Name = "Gent", ZipCode = 9000 }
            );
        }

        public void CreateOrUpdateDatabase()
        {
            Database.Migrate();
        }
    }
}
