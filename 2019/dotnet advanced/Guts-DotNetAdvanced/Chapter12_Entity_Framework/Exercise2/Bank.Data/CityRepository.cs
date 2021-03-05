using System;
using System.Collections.Generic;
using System.Linq;
using Bank.Data.DomainClasses;
using Bank.Data.Interfaces;

namespace Bank.Data
{
    public class CityRepository : ICityRepository
    {
        private BankContext _context;

        public CityRepository(BankContext context)
        {
            _context = context;
        }

        public IList<City> GetAll()
        {
            return _context.Cities.ToList();
        }
    }
}