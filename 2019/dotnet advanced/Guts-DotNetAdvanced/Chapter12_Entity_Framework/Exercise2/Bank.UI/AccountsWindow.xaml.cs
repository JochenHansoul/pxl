using System;
using Bank.Data.DomainClasses;
using Bank.Data.Interfaces;
using System.Windows;
using Bank.Business.Interfaces;
using System.Collections.ObjectModel;
using System.Collections.Generic;
using System.Linq;
using Bank.Business;

namespace Bank.UI
{
    public partial class AccountsWindow : Window
    {
        private Customer _customer;
        private IAccountValidator _accountValidator;
        private IAccountRepository _accountRepository;
        private IWindowDialogService _windowDialogService;


        public AccountsWindow(Customer customer,
            IAccountRepository accountRepository,
            IAccountValidator accountValidator,
            IWindowDialogService windowDialogService)
        {
            InitializeComponent();

            _customer = customer;
            _accountValidator = accountValidator;
            _accountRepository = accountRepository;
            _windowDialogService = windowDialogService;
            AccountsDataGrid.ItemsSource = customer.Accounts.ToList(); //hier fout?
            DataContext = customer.FirstName + " " + customer.Name;
        }

        private void AddAccountButton_Click(object sender, RoutedEventArgs e)
        {
            /*ErrorTextBlock.Text = "";
            var account = (Account)AccountsDataGrid.SelectedItem;
            _accountValidator.IsValid(account);
            _accountRepository.Add(account);
            */
        }

        private void SaveAccountButton_Click(object sender, RoutedEventArgs e)
        {

            var selectedAccount = (Account)AccountsDataGrid.SelectedItem;
            if (selectedAccount != null)
            {
                ValidatorResult validatorResult = _accountValidator.IsValid(selectedAccount);
                if (validatorResult.IsValid)
                {
                    // check if account already exist
                    var accountAlreadyExists = false;
                    foreach (Account account in _customer.Accounts)
                    {
                        if (account.Equals(selectedAccount)) accountAlreadyExists = true;
                    }
                    if (accountAlreadyExists)
                    {
                        _accountRepository.Update(selectedAccount);
                    }
                    else
                    {
                        _accountRepository.Add(selectedAccount);
                    }
                    ErrorTextBlock.Text = "";
                }
                else
                {
                    ErrorTextBlock.Text = validatorResult.Message;
                }
            }
            else
            {
                ErrorTextBlock.Text = "error";
            }
            AccountsDataGrid.CanUserAddRows = false;
        }

        private void TransferButton_Click(object sender, RoutedEventArgs e)
        {
            //_windowDialogService.ShowAccountDialogForCustomer(_customer);
            if (AccountsDataGrid.SelectedItem != null)
            {
                _windowDialogService.ShowTransferDialog((Account)AccountsDataGrid.SelectedItem, _customer.Accounts);
            }

        }
    }
}
