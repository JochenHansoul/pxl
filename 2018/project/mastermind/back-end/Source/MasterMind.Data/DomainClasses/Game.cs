using System;
using System.Collections.Generic;
using System.Linq;


namespace MasterMind.Data.DomainClasses
{
    public class Game : IGame
    {

        private static string[] _allColors = { "red", "brown", "orange", "green", "yellow", "purple", "black", "blue" }; 
        private static string[] _possibleColors;
        private string[] _codeToGuess;
        private int _currentRound;
        private IList<int> guessCounter = new List<int>();
        private Dictionary<Guid, IList<GuessResult>> guessResultDictionary = new Dictionary<Guid, IList<GuessResult>>();
        private IList<int> _indexColorList = new List<int>();
        private IList<IPlayer> _players;
        private GameSettings _settings;

        // properties

        public Guid Id { get; set; }

        public GameSettings Settings
        {
            get { return _settings; }
            set { _settings = value; }
        }

        public IList<IPlayer> Players => _players;

        public string[] PossibleColors => _possibleColors;
       
        public int CurrentRound => _currentRound;


        /// <summary>
        /// Constructs a Game object and generates a code to guess.
        /// </summary>
        public Game(GameSettings settings, IList<IPlayer> players)
        {
            
            _settings = settings;
            _players = players;
            _currentRound = 0;
            _possibleColors = new string[_settings.AmountOfColors];

            
            foreach (IPlayer player in _players)
            {
                guessCounter.Add(0);
                guessResultDictionary.Add(player.Id, new List<GuessResult>());
            }

            for(int i = 0; i < settings.AmountOfColors; i++)
            {
                _possibleColors[i] = _allColors[i];
                _indexColorList.Add(i);
            }

            _codeToGuess = GenerateGameCode(_settings.CodeLength, _settings.DuplicateColorsAllowed);
        }

        public CanGuessResult CanGuessCode(IPlayer player, int roundNumber)
        {
            CanGuessResult result;
            IList<Guid> idList = new List<Guid>(); // begin aanpassing
            foreach(IPlayer p in _players)
            {
                idList.Add(p.Id);
            }

            int playerIndex = idList.IndexOf(player.Id); // einde aanpassing
            if (guessCounter[playerIndex].Equals(_settings.MaximumAmountOfGuesses))
            {
                result = CanGuessResult.MaximumReached;
            }
            else if (_currentRound > roundNumber)
            {
                result = CanGuessResult.NotAllowedDueToGameStatus;
            }
            else if (!guessCounter.All(element => element >= guessCounter[playerIndex]))
            {
                result = CanGuessResult.MustWaitOnOthers;
            }
            else if (_currentRound < roundNumber)
            {
                result = CanGuessResult.RoundNotStarted;
            }
            else
            {
                result = CanGuessResult.Ok;
            }
            return result;
        }

        public GuessResult GuessCode(string[] colors, IPlayer player)
        {
            IList<Guid> idList = new List<Guid>(); // begin aanpassing
            foreach (IPlayer p in _players)
            {
                idList.Add(p.Id);
            }

            int playerIndex = idList.IndexOf(player.Id); // einde aanpassing
            Guid currentPlayerId = _players[playerIndex].Id;

            GuessResult playerGuess = new GuessResult(colors);

            playerGuess.Verify(_codeToGuess);
            guessCounter[playerIndex]++;
            if (playerGuess.CorrectColorAndPositionAmount.Equals(_codeToGuess.Length))
            {
                _currentRound++;
            }
            else if (guessCounter.All(element => element == _settings.MaximumAmountOfGuesses))
            {
                _currentRound++;
            }
            guessResultDictionary[currentPlayerId].Add(playerGuess);

            return playerGuess;
        }

        public GameStatus GetStatus()
        {
            GameStatus status = new GameStatus();
            
            int lengthCodeToGuess = _codeToGuess.Length;
            int lastIndexOfGuessResultList = _players.Count - 1;

            status.CurrentRoundNumber = _currentRound;

            // roundwinner is included in the status
            
            //if (guessResultDictionary.Any(element => element.Value[lastIndexOfGuessResultList].CorrectColorAndPositionAmount.Equals(lengthCodeToGuess)))
            //{
            //    status.GameOver = true;
            //    foreach(KeyValuePair<Guid, IList<GuessResult>> pair in guessResultDictionary)
            //    {
            //        if(pair.Value[lastIndexOfGuessResultList].CorrectColorAndPositionAmount.Equals(lengthCodeToGuess))
            //        {
            //            IPlayer winner = _players.Where(p => p.Id == pair.Key).First();
            //            status.FinalWinner = winner;
            //        }
            //    }
            //}
            
            return status;
        }

        private string[] GenerateGameCode(int codeLength, bool duplicateColorsAllowed)
        {
            Random codeGenerator = new Random();
            string[] code = new string[codeLength];
            int randomNumber;

            if (duplicateColorsAllowed)
            {
                for (int i = 0; i < codeLength; i++) 
                {
                    randomNumber = codeGenerator.Next(0, _possibleColors.Length);
                    code[i] = (_possibleColors[randomNumber]);
                }
            }
            else
            {
                IList<int> indexList = _indexColorList;
                for (int k = 0; k < codeLength; k++)
                {
                    randomNumber = codeGenerator.Next(0, indexList.Count);
                    code[k] = _possibleColors[indexList[randomNumber]];
                    indexList.RemoveAt(randomNumber);
                }
            }

            return code;
        }
    }
}