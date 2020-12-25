using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Exercise7_BankAccount
{
    public class BankAccount
    {
        private int _saldo = 0;
        private string _accountNumber;
        private string _owner = "No name included";
        private const int MinSaldo = 0;
        private const int MaxDeposit = 2500;

        // constructor
        public BankAccount(string accountNumber)
        {
            _accountNumber = accountNumber;
        }

        // properties
        public int Deposit { get; set; }
        public int Withdraw { get; set; }


        public int Deposit
        {
            set {
                try
                {
                    int amount = int.Parse(amountTextBox.Text);
                    if (amount < 0)
                    {
                        BankAccount.Credit(-amount)
                    }
                    else
                    {
                        BankAccount.MaxDeposit(amount);
                    }
                    balanceTextBox.Text = Convert.ToString(BankAccount.Balance);

                }
                catch (FormatException ex)
                {
                    MessageBox.Show("000");
                }
                catch (BankException ex)
                {
                    MessageBox.Show("...");
                }
            }
        }
    }
}
