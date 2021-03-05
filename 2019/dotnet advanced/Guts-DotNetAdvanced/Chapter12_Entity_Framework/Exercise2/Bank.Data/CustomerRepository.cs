using System;
using System.Collections.Generic;
using System.Linq;
using Bank.Data.DomainClasses;
using Bank.Data.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace Bank.Data
{
    public class CustomerRepository : ICustomerRepository
    {
        private BankContext _context;

        public CustomerRepository(BankContext context)
        {
            _context = context;
        }

        public IList<Customer> GetAllWithAccounts()
        {
            return _context.Customers.Include(c => c.Accounts).ToList();
        }

        public void Update(Customer existingCustomer)
        {
            if (!_context.Customers.Contains(existingCustomer)) throw new ArgumentException();

            _context.Customers.Update(existingCustomer);
            _context.SaveChanges();
        }

        public void Add(Customer newCustomer)
        {
            if (_context.Customers.Contains(newCustomer)) throw new ArgumentException();
            
            _context.Customers.Add(newCustomer);
            _context.SaveChanges();
        }
    }
}