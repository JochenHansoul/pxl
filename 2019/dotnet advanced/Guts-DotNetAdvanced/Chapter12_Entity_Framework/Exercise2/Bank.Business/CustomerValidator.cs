using System;
using Bank.Business.Interfaces;
using Bank.Data.DomainClasses;
using Bank.Data.Interfaces;

namespace Bank.Business
{
    public class CustomerValidator : ICustomerValidator
    {
        ICityRepository _cityRepository;

        public CustomerValidator(ICityRepository cityRepository)
        {
            _cityRepository = cityRepository;
        }

        public ValidatorResult IsValid(Customer customer)
        {
            if (customer == null) return ValidatorResult.Fail("no customer object");

            var firstName = customer.FirstName;
            if (firstName == null || firstName == "") return ValidatorResult.Fail("firstname is null");
            var name = customer.Name;
            if (name == null || name == "") return ValidatorResult.Fail("name is null");

            var zipCode = customer.ZipCode;
            foreach(City city in _cityRepository.GetAll())
            {
                if (zipCode == city.ZipCode) return ValidatorResult.Success(); ;
            }
            return ValidatorResult.Fail("Zip code is incorrect");
            
            
        }
    }
}
