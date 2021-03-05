using System;
using System.Collections.Generic;
using System.Linq;
using Bank.Data.DomainClasses;
using Bank.Data.Interfaces;
using Microsoft.EntityFrameworkCore;
using Xamarin.Forms;

namespace Bank.Data
{
    public class AccountRepository : IAccountRepository
    {
        private BankContext _context;

        public AccountRepository(BankContext context)
        {
            _context = context;
        }

        public void Add(Account newAccount)
        {
            if (_context.Accounts.Contains(newAccount)) throw new ArgumentException();
            if (!_context.Database.CanConnect() && _context.Customers.Contains(newAccount.Customer))
            {
                throw new DbUpdateException("unique constraint", new Exception());
            }
            _context.Accounts.Add(newAccount);
            _context.SaveChanges();
        }

        public void Update(Account existingAccount)
        {
            if (!_context.Accounts.Contains(existingAccount)) throw new ArgumentException();

            // compare balance original and current account
            var originalValues = _context.Entry(existingAccount).OriginalValues;
            if (originalValues.GetValue<decimal>("Balance") != existingAccount.Balance) throw new InvalidOperationException();

            _context.Accounts.Update(existingAccount);
            _context.SaveChanges();
        }

        public void TransferMoney(int fromAccountId, int toAccountId, decimal amount)
        {
            var fromAccount = _context.Accounts
                .Where(a => a.Id == fromAccountId)
                .FirstOrDefault();
            fromAccount.Balance = fromAccount.Balance - amount;

            var toAccount = _context.Accounts
                .Where(a => a.Id == toAccountId)
                .FirstOrDefault();
            toAccount.Balance = toAccount.Balance + amount;
            _context.SaveChanges();
        }
    }
}
