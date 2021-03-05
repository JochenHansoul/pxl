using System;
using System.Collections.Generic;
using System.Windows;
using Bank.Data.DomainClasses;
using Bank.Data.Interfaces;

namespace Bank.UI
{
    public partial class TransferWindow : Window
    {
        private Account _fromAccount;
        private IAccountRepository _accountRepository;

        public TransferWindow(Account fromAccount,
            IEnumerable<Account> allAccountsOfCustomer,
            IAccountRepository accountRepository)
        {
            InitializeComponent();

            _fromAccount = fromAccount;
            _accountRepository = accountRepository;
            MainGrid.DataContext = fromAccount;
            ToAccountComboBox.ItemsSource = allAccountsOfCustomer;
            //FromAccountTextBlock.Text = fromAccount.AccountNumber;
        }

        private void TransferButton_Click(object sender, RoutedEventArgs e)
        {
            var toAccount = (Account) ToAccountComboBox.SelectedItem;
            var amount = decimal.Parse(AmountTextBox.Text);
            //Convert.ToInt32()
            if (amount > 0 && _fromAccount.Balance >= amount)
            {
                _accountRepository.TransferMoney(_fromAccount.Id, toAccount.Id, amount);
            }
            else
            {
                ErrorMessageTextBlock.Text = _fromAccount.Balance + "";
                ErrorMessageTextBlock.Visibility = Visibility.Visible;
            }

        }
    }
}
