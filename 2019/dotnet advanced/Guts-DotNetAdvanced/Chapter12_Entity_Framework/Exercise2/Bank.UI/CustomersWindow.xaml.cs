using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Windows;
using Bank.Business.Interfaces;
using Bank.Data;
using Bank.Data.DomainClasses;
using Bank.Data.Interfaces;
using Bank.Business;
using Moq;

namespace Bank.UI
{
    public partial class CustomersWindow : Window
    {
        private ICustomerRepository _customerRepository;
        private ICustomerValidator _customerValidator;
        private ICityRepository _cityRepository;
        private IWindowDialogService _windowDialogService;

        public CustomersWindow(ICustomerRepository customerRepository,
            ICustomerValidator customerValidator,
            ICityRepository cityRepository, 
            IWindowDialogService windowDialogService)
        {
            InitializeComponent();

            _customerRepository = customerRepository;
            _customerValidator = customerValidator;
            _cityRepository = cityRepository;
            _windowDialogService = windowDialogService;

            CustomersDataGrid.ItemsSource = customerRepository.GetAllWithAccounts();
            CityComboBoxColumn.ItemsSource = cityRepository.GetAll();
        }

        private void AddCustomerButton_Click(object sender, RoutedEventArgs e)
        {
            CustomersDataGrid.DataContext = new List<Customer>(); //dit werkt niet echt
        }

        private void SaveCustomerButton_Click(object sender, RoutedEventArgs e)
        {
            var newCustomer = (Customer)CustomersDataGrid.SelectedItem;
            if (CustomersDataGrid.SelectedItem != null)
            {
                ValidatorResult validatorResult = _customerValidator.IsValid(newCustomer);
                if (validatorResult.IsValid)
                {
                    _customerRepository.Update(newCustomer);

                    /*
                    // a test with data from the grid
                    var isAlreadyAdded = false;
                    var items = CustomersDataGrid.Items;
                    items.Remove(CustomersDataGrid.SelectedItem);
                    foreach (var item in items)
                    {
                        if (newCustomer.Equals((Customer)item)) isAlreadyAdded = true;
                    }
                    */

                    /*
                    List<Customer> customers = (List<Customer>)_customerRepository.GetAllWithAccounts();
                    if (customers.Contains(newCustomer))
                    {
                        _customerRepository.Update(newCustomer);
                    }
                    else
                    {
                        _customerRepository.Add(newCustomer);
                    }
                    */
                    ErrorTextBlock.Text = "";
                }
                else
                {
                    ErrorTextBlock.Text = validatorResult.Message;
                    ErrorTextBlock.Visibility = Visibility.Visible;
                }
            }
            else
            {
                ErrorTextBlock.Text = "error";
            }
            CustomersDataGrid.CanUserAddRows = false;



            /*
            try
            {
                if (CustomersDataGrid.SelectedItem == null) throw new Exception("no account selected");
                var newCustomer = (Customer)CustomersDataGrid.SelectedItem;
                ValidatorResult validatorResult = _customerValidator.IsValid(newCustomer);
                if (!validatorResult.IsValid) throw new Exception("");

                List<Customer> customers = (List<Customer>)_customerRepository.GetAllWithAccounts();
                var customerIsAlreadyAdded = customers.Contains(newCustomer);
                if (customerIsAlreadyAdded)
                {
                    _customerRepository.Update(newCustomer);
                }
                else
                {
                    _customerRepository.Add(newCustomer);
                }
                ErrorTextBlock.Text = "";
            }
            catch (Exception ex)
            {
                ErrorTextBlock.Text = ex.Message.ToString();
            }
            */
        }

        private void ShowAccountsButton_Click(object sender, RoutedEventArgs e)
        {
            if ((Customer)CustomersDataGrid.SelectedItem != null)
            {
                _windowDialogService.ShowAccountDialogForCustomer((Customer)CustomersDataGrid.SelectedItem);
            }
        }
    }
}
