using System;
using System.IO;
using System.Windows;

namespace PixelPass
{
    public class AccountInfoCollectionReader
    {
        public static IAccountInfoCollection Read(string filename)
        {
            StreamReader reader = null;
            AccountInfoCollection accountInfoCollection = null;
            string directoryPath = null;
            string filePath = null;
            try
            {
                directoryPath = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
                filePath = System.IO.Path.Combine(directoryPath, filename);
                reader = File.OpenText(filePath);
                string[] firstLine = reader.ReadLine().Split(' ');
                if (firstLine[0] != "Name:") throw new ParseException("File does not start with 'Name:'");
                accountInfoCollection = new AccountInfoCollection(firstLine[1]);
                string line = reader.ReadLine();
                while (line != null)
                {
                    string[] accountInfo = line.Split(',');
                    string[] dateArray = accountInfo[4].Split('/');
                    DateTime date = new DateTime(Convert.ToInt32(dateArray[2]), Convert.ToInt32(dateArray[1]), Convert.ToInt32(dateArray[0]));
                    AccountInfo account = new AccountInfo(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3], date);
                    accountInfoCollection.AddAccountInfo(account);
                    line = reader.ReadLine();
                }
            }
            catch (ParseException)
            {
                string message = $"{filePath} seems to be corrupt." + Environment.NewLine;
                message += "Details" + Environment.NewLine;
                message += $"{filePath} does not start with 'Name:'";
                MessageBox.Show(message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                reader?.Close();
            }
            return accountInfoCollection;
        }
    }
}
