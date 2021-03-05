using System.Runtime.Serialization;
using System.Windows;
using System.Windows.Controls;
using Lottery.Business.Interfaces;
using Lottery.Data;
using Lottery.Data.Interfaces;
using Lottery.Domain;

namespace Lottery.UI
{
    public partial class LotteryWindow : Window
    {
        private IDrawRepository _drawRepository;
        private IDrawService _drawService;

        public LotteryWindow(ILotteryGameRepository lotteryGameRepository,
            IDrawRepository drawRepository, IDrawService drawService)
        {
            InitializeComponent();
            _drawRepository = drawRepository; //hier een fout gemaakt
            _drawService = drawService;
            GameComboBox.SelectedIndex = 0;
            GameComboBox.ItemsSource = lotteryGameRepository.GetAll();


        }

        private void ShowDrawsButton_Click(object sender, RoutedEventArgs e)
        {
            //Do NOT change any code in this method

            RetrieveDraws();

            NewDrawButton.Visibility = Visibility.Visible;
            DrawsListView.Visibility = Visibility.Visible;
        }

        private void NewDrawButton_OnClick(object sender, RoutedEventArgs e)
        {
            //TODO: create the draw
            _drawService.CreateDrawFor((LotteryGame)GameComboBox.SelectedItem);
            RetrieveDraws(); //Refresh the draws that are shown in the ListView
        }

        private void GameComboBox_OnSelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            //Do NOT change any code in this method

            NewDrawButton.Visibility = Visibility.Hidden;
            DrawsListView.Visibility = Visibility.Hidden;
        }

        private void RetrieveDraws()
        {
            //TODO: get the draws and show them
            DrawsListView.Items.Clear();
            DrawsListView.ItemsSource = _drawRepository.Find(((LotteryGame)GameComboBox.SelectedItem).Id, FromDatePicker.SelectedDate, UntilDatePicker.SelectedDate);
        }
    }
}
