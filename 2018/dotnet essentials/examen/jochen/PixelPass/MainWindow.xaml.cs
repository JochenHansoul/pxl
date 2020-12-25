using Microsoft.Win32;
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
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace PixelPass
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        /*
         * Ik weet niet hoe ik de list aan de listbox moet koppelen
         * Ik weet niet hoe ik het originele window moest sluiten en openen en het 2e window sluit ook niet
         * De dataTime is CreateAccountWindow is niet gelukt
         * de using namespaces vergeten te verwijderen
         * 1 catch exception is een lege string
         * voor pasword validator hebt id de TextBlock genomen i.p.v. de TextBlock en de gebruikte methode moest TextChanged="" zijn
         * De classe PasswordValidator is haastig geïmplementeerd
         */
        private IAccountInfoCollection _accountInfoCollection; // doordat dit een ilist is
        private AccountInfo _currentAccountInfo;
        private DispatcherTimer _timer;
        
        public MainWindow()
        {
            InitializeComponent();

            _timer = new DispatcherTimer();
            _timer.Interval = TimeSpan.FromSeconds(1);
            expirationProgressBar.Minimum = 0;
            expirationProgressBar.Maximum = 5;
        }

        public void AddAccountInfoCollection(AccountInfo account)
        {
            MessageBox.Show(account.Username);
            //int accounts = _accountInfoCollection.AccountInfos.Count;
            _accountInfoCollection.AccountInfos.Add(account);
            //MessageBox.Show($"account added {_accountInfoCollection.AccountInfos.Count - accounts}");
        }

        private void timer_Tick(object senter, EventArgs e)
        {
            expirationProgressBar.Value += 1;
            if (expirationProgressBar.Value >= 5)
            {
                _timer.Stop();
                Clipboard.SetText("");
            }
        }

        private void OpenItem_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                _accountInfoCollection = AccountInfoCollectionReader.Read("pietpienter.txt");
                for (int i = 0; i < _accountInfoCollection.AccountInfos.Count; i++)
                {
                    AccountInfo accountInfo = _accountInfoCollection.AccountInfos[i];
                    ListBoxItem newItem = new ListBoxItem();
                    newItem.Content = accountInfo.ToString();
                    accountInfoListBox.Items.Add(newItem);
                    //accountInfoListBox.ItemsSource = accountInfo.ToString();
                }
                newAccountInfoButton.IsEnabled = true;
            }
            catch (SystemException)
            {
                MessageBox.Show(""); // dit ben ik vergeten in te vullen
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void AccountInfoListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            int index = accountInfoListBox.SelectedIndex;
            ListBoxItem item = (ListBoxItem)accountInfoListBox.Items[index];
            string accountName = Convert.ToString(item.Content);

            _currentAccountInfo = _accountInfoCollection.AccountInfos[index];
            titleTextBlock.Text = _currentAccountInfo.Title;
            usernameTextBlock.Text = _currentAccountInfo.Username;
            notesTextBlock.Text = _currentAccountInfo.Notes;
            expirationTextBlock.Text = Convert.ToString(_currentAccountInfo.Expiration);
            string end = "";
            if (accountName.Contains(' ')) end = accountName.Split(' ')[1];
            if (end == "(expired)")
            {
                detailsCanvas.Background = new SolidColorBrush(Colors.LightCoral);
                copyButton.IsEnabled = false;
            }
            else
            {
                detailsCanvas.Background = new SolidColorBrush(Colors.White);
                copyButton.IsEnabled = true;
            }
        }

        private void CopyButton_Click(object sender, RoutedEventArgs e)
        {
            Clipboard.SetText(_currentAccountInfo.Password);
            expirationProgressBar.Value = 0;
            _timer.Tick += timer_Tick;
            _timer.Start();
        }

        private void NewAccountInfoButton_Click(object sender, RoutedEventArgs e)
        {
            CreateAccountInfoWindow createAccountWindow = new CreateAccountInfoWindow();
            createAccountWindow.titleTextBox.Text = _currentAccountInfo.Title;
            createAccountWindow.usernameTextBox.Text = _currentAccountInfo.Username;
            createAccountWindow.passwordTextBox.Text = _currentAccountInfo.Password;
            createAccountWindow.notesTextBox.Text = _currentAccountInfo.Notes;

            createAccountWindow.ShowDialog();
        }

        private void ExitItem_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
