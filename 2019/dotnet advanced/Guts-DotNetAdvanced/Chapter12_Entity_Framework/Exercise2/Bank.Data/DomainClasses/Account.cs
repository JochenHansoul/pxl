using Bank.Data.DomainClasses.Enums;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Bank.Data.DomainClasses
{
    public class Account : INotifyPropertyChanged
    {
        public int Id { get; set; }

        public string AccountNumber { get; set; }

        private decimal _balance;

        public AccountType AccountType { get; set; }
        
        public int CustomerId { get; set; }

        public Customer Customer { get; set; }

        public event PropertyChangedEventHandler PropertyChanged;

        public decimal Balance
        {
            get => _balance;
            set
            {
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs("Balance"));
                _balance = value;
            }
        }
    }
}
