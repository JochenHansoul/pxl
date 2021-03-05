﻿// <auto-generated />
using Bank.Data;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

namespace Bank.Data.Migrations
{
    [DbContext(typeof(BankContext))]
    [Migration("20200108134328_AddCustomerToAccount")]
    partial class AddCustomerToAccount
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "2.2.6-servicing-10079")
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("Bank.Data.DomainClasses.Account", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("AccountNumber")
                        .IsRequired();

                    b.Property<int>("AccountType");

                    b.Property<decimal>("Balance");

                    b.Property<int>("CustomerId");

                    b.HasKey("Id");

                    b.HasIndex("CustomerId");

                    b.ToTable("Accounts");
                });

            modelBuilder.Entity("Bank.Data.DomainClasses.City", b =>
                {
                    b.Property<int>("ZipCode")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("Name");

                    b.HasKey("ZipCode");

                    b.ToTable("Cities");

                    b.HasData(
                        new
                        {
                            ZipCode = 2000,
                            Name = "Antwerpen"
                        },
                        new
                        {
                            ZipCode = 3000,
                            Name = "Leuven"
                        },
                        new
                        {
                            ZipCode = 3500,
                            Name = "Hasselt"
                        },
                        new
                        {
                            ZipCode = 8000,
                            Name = "Brugge"
                        },
                        new
                        {
                            ZipCode = 9000,
                            Name = "Gent"
                        });
                });

            modelBuilder.Entity("Bank.Data.DomainClasses.Customer", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("Address");

                    b.Property<string>("CellPhone");

                    b.Property<string>("FirstName")
                        .IsRequired();

                    b.Property<string>("Name")
                        .IsRequired();

                    b.Property<int>("ZipCode");

                    b.HasKey("Id");

                    b.HasIndex("ZipCode");

                    b.ToTable("Customers");
                });

            modelBuilder.Entity("Bank.Data.DomainClasses.Account", b =>
                {
                    b.HasOne("Bank.Data.DomainClasses.Customer", "Customer")
                        .WithMany("Accounts")
                        .HasForeignKey("CustomerId")
                        .OnDelete(DeleteBehavior.Cascade);
                });

            modelBuilder.Entity("Bank.Data.DomainClasses.Customer", b =>
                {
                    b.HasOne("Bank.Data.DomainClasses.City", "City")
                        .WithMany("Customers")
                        .HasForeignKey("ZipCode")
                        .OnDelete(DeleteBehavior.Cascade);
                });
#pragma warning restore 612, 618
        }
    }
}
