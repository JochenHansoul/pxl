using MasterMind.Data.DomainClasses;
using System;
using System.Collections.Generic;
using System.Linq;
using MasterMind.Data.Repositories;

namespace MasterMind.Business.Services
{
    public class GameService : IGameService
    {
        private IWaitingRoomService _waitingRoomService;
        private IGameRepository _gameRepository;

        public GameService(IWaitingRoomService waitingRoomService, IGameRepository gameRepository)
        {
            this._waitingRoomService = waitingRoomService;
            this._gameRepository = gameRepository;
        }

        public IGame StartGameForRoom(Guid roomId) // game klasse moet nog eerst gemaakt worden dan kan deze pas getest worden
        {
            WaitingRoom currentWaitingRoom = _waitingRoomService.GetRoomById(roomId);
            IList<User> usersInCurrentWaitingRoom = currentWaitingRoom.Users; 
            IList<IPlayer> playersInCurrentWaitingRoomGame = new List<IPlayer>();

            foreach (User user in usersInCurrentWaitingRoom)
            {
                playersInCurrentWaitingRoomGame.Add(user);
            }

            HasEnoughPlayers(playersInCurrentWaitingRoomGame);
            IGame newGame = new Game(currentWaitingRoom.GameSettings, playersInCurrentWaitingRoomGame);
            _gameRepository.Add(newGame);
            currentWaitingRoom.GameId = newGame.Id;
            
            return newGame;
        }

        public IGame GetGameById(Guid id)
        {
            return _gameRepository.GetById(id);
        }

        public CanGuessResult CanGuessCode(Guid gameId, IPlayer player, int roundNumber)
        {
            IGame game = _gameRepository.GetById(gameId);
            return game.CanGuessCode(player, roundNumber);
        }

        public GuessResult GuessCode(Guid gameId, string[] colors, IPlayer player)
        {
            IGame game = _gameRepository.GetById(gameId);
            CanGuessResult playerCanGuess = game.CanGuessCode(player, game.CurrentRound);
            if (playerCanGuess == CanGuessResult.Ok)
            {
                return game.GuessCode(colors, player);
            }
            else
            {
                throw new ApplicationException("Player Can't make a Guess.");
            }
        }

        public GameStatus GetGameStatus(Guid gameId)
        {
            IGame game = _gameRepository.GetById(gameId);
            return game.GetStatus();
        }

        private void HasEnoughPlayers(IList<IPlayer> players)
        {
            if (players.Count < 2)
            { 
                throw new ApplicationException("Number of players is less than the minimum number of players (2)");
            }
        }

    }
}