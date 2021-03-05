﻿using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.Windows;

namespace Exercise3
{
    public partial class MainWindow : Window
    {
        private ObservableCollection<Game> games;

        public MainWindow()
        {
            InitializeComponent();
            GamesListView.ItemsSource = GetDummyGames();
            DataContext = new Game();
        }

        private IList<Game> GetDummyGames()
        {
            games = new ObservableCollection<Game>
            {
                new Game
                {
                    Name = "GTA V",
                    Description =
                        "Dit is een spel waarbij een speler allerlei handelingen kan doen zoals rennen, zwemmen, autorijden om het spel te navigeren.Hoe kan je de game uitspelen ? Door alle missies te halen en niet gepakt te worden door politie.",
                },
                new Game
                {
                    Name = "Call of Duty:Infinite Warfare",
                    Description =
                        "Het is een game waarbij je missies uitvoert en heeft een zombiemodus. Je speelt dit spel op veel verschillende plekken en schiet vaak vanuit de cockpit in plaats van tijdens het lopen.",
                }
            };
            return games;
        }

        private void GamesListView_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
            DataContext = GamesListView.SelectedItem;
        }

        private void AddNewGameButton_Click(object sender, RoutedEventArgs e)
        {
            Game game = NewGameGroupBox.DataContext as Game; //Blijkbaarselecteerd dit het game in de groupbox en maakt er
            //kan dit ook zonder NewGameGroupBox?

            if (game.Name == null || game.Description == null || game.Name == "" || game.Description == "")
            {
                ErrorMessageTextBlock.Text = "the name of the game cannot be empty";
            }
            else
            {
                // adding game
                games.Add(game);
                DataContext = new Game();
                ErrorMessageTextBlock.Text = "";
            };
        }
    }
}
