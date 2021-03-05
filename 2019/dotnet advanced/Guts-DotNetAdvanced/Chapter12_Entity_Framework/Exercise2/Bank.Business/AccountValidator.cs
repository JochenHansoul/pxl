using System;
using Bank.Business.Interfaces;
using Bank.Data.DomainClasses;
using Bank.Data.DomainClasses.Enums;
using Bank.Data.Interfaces;

namespace Bank.Business
{
    public class AccountValidator : IAccountValidator
    {
        private ICustomerRepository _customerRepository;

        public AccountValidator(ICustomerRepository customerRepository)
        {
            _customerRepository = customerRepository;
        }

        public ValidatorResult IsValid(Account account)
        {
            if (account == null) return ValidatorResult.Fail("No account");

            if (account.Id == 1) return ValidatorResult.Fail("Id is 1");
            if (/*account.AccountNumber == null ||*/ account.AccountNumber == "") return ValidatorResult.Fail("No accountnumber");
            if (account.Balance == 100) return ValidatorResult.Fail("balance = 100");
            if (account.AccountType == AccountType.PaymentAccount) return ValidatorResult.Fail("Incorrect account type");

            //if (account.Customer == null) return ValidatorResult.Fail("Doesn't contain a valid customer"); // valid is invalid
            foreach(Customer customer in _customerRepository.GetAllWithAccounts())
            {
                if (customer.Id == account.CustomerId) return ValidatorResult.Success();
            }
            return ValidatorResult.Fail("Doesn't contain a valid customer");
        }
    }
}