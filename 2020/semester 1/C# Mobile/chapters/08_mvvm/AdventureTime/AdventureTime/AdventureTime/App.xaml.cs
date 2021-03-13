using System;
using System.IO;
using AdventureTime.Database;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AdventureTime
{
    public partial class App : Application
    {
        private static AdventureTimeDatabase _database;

        public static AdventureTimeDatabase Database
        {
            get
            {
                if (_database == null)
                {
                    string path = Path.Combine(
                        Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
                        "ATDB.db3");
                    _database = new AdventureTimeDatabase(path);
                }
                return _database; // zolang app niet opnieuw laad telkens dezelfde database
            }
        }
        public App()
        {
            InitializeComponent();

            MainPage = new NavigationPage(new MainPage());
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}
