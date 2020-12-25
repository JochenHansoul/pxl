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

namespace Exercise06_StonePaperScissor
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string personChoice;
        private string computerChoice;
        private bool notPlayedYet = true;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void StoneButton_Click(object sender, RoutedEventArgs e)
        {
            personChoice = "stone";
            PlayTheGame();
        }

        private void PaperPutton_Click(object sender, RoutedEventArgs e)
        {
            personChoice = "paper";
            PlayTheGame();
        }

        private void ScissorButton_Click(object sender, RoutedEventArgs e)
        {
            personChoice = "scissor";
            PlayTheGame();
        }

        private void computerMakesHisChoice()
        {
            Random random = new Random();
            int randomNumber = random.Next(3);
            switch(randomNumber)
            {
                case 0:
                    computerChoice = "stone";
                    break;
                case 1:
                    computerChoice = "paper";
                    break;
                case 2:
                    computerChoice = "scissor";
                    break;
            }
        }

        private void SelectWinner()
        {
            outputLabel.Content = computerChoice;
            if (personChoice == computerChoice)
            {
                winnerLabel.Content = "Gelijkspel";
            }
            else
            {
                winnerLabel.Content = "U hebt ";
                switch(personChoice)
                {
                    case "stone":
                        winnerLabel.Content += computerChoice == "scissor" ? "gewonnen" : "verloren";
                        break;
                    case "paper":
                        winnerLabel.Content += computerChoice == "stone" ? "gewonnen" : "verloren";
                        break;
                    case "scissor":
                        winnerLabel.Content += computerChoice == "paper" ? "gewonnen" : "verloren";
                        break;
                    default:
                        winnerLabel.Content += "iets verkeerd gedaan";
                        break;
                }
            }
        }

        private void PlayTheGame()
        {
            if (notPlayedYet)
            {
                computerMakesHisChoice();
                SelectWinner();
                replayButton.Visibility = Visibility.Visible;
                notPlayedYet = false;
            }
        }

        private void ReplayButton_Click(object sender, RoutedEventArgs e)
        {
            outputLabel.Content = "";
            winnerLabel.Content = "";
            replayButton.Visibility = Visibility.Hidden;
            notPlayedYet = true;
        }
    }
}
