using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace PixelPass
{
    /// <summary>
    /// Interaction logic for CreateOrUpdateAccountInfoWindow.xaml
    /// </summary>
    public partial class CreateAccountInfoWindow : Window
    {
        public CreateAccountInfoWindow()
        {
            InitializeComponent();
        }

        private void ExpirationSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            //expirationDateTextBlock.Text = Convert.ToString(expirationSlider.Value);
            int monthNumber = DateTime.Now.Month;

            int days = Convert.ToInt32(expirationSlider.Value) + DateTime.Now.Day;
            int months = monthNumber;
            int years = DateTime.Now.Year;

            int daysInCurrentMonth = DateTime.DaysInMonth(years, monthNumber);
            if (days > daysInCurrentMonth)
            {
                days -= (daysInCurrentMonth - monthNumber);
                months++;
                if (months > 12)
                {
                    months = 1;
                    years++;
                }
            }
            DateTime expirationDate = new DateTime(years, months, days);
            if (expirationDateTextBlock != null) expirationDateTextBlock.Text = expirationDate.ToString("dd/MM/yyyy");
        }

        private void PasswordTextBox_TextInput(object sender, TextCompositionEventArgs e)
        {
            passwordStrengthTextBlock.Text = Convert.ToString(PasswordValidator.CalculateStrength(passwordStrengthTextBlock.Text));
        }

        private void CreateButton_Click(object sender, RoutedEventArgs e)
        {
            AddAccountToMainWindow();
        }

        private void AddAccountToMainWindow()
        {
            string[] expirationArray = expirationDateTextBlock.Text.Split('/');
            DateTime expirationDate = new DateTime(Convert.ToInt32(expirationArray[2]), Convert.ToInt32(expirationArray[1]), Convert.ToInt32(expirationArray[0]));
            AccountInfo newAccount = new AccountInfo(titleTextBox.Text, usernameTextBox.Text, passwordTextBox.Text, notesTextBox.Text, expirationDate);
            MainWindow mainWindow = new MainWindow();
            mainWindow.AddAccountInfoCollection(newAccount);
            CreateAccountInfoWindow currentWindow = new CreateAccountInfoWindow();
            currentWindow.Close();
        }

        private void PasswordTextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            passwordStrengthTextBlock.Text = Convert.ToString(PasswordValidator.CalculateStrength(passwordTextBox.Text));
        }
    }
}
