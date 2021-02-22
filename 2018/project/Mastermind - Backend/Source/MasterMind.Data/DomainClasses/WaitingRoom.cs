using System;
using System.Collections.Generic;

namespace MasterMind.Data.DomainClasses
{
    public class WaitingRoom
    {
        public const int DefaultMaximumAmountOfUsers = 4;
        private string _name;
        private User _creator;
        private Guid _creatorUserId;
        private GameSettings _gameSettings;
        private IList<User> _users = new List<User>();

        public WaitingRoom(string name, User creator, GameSettings gameSettings)
        {
            _name = name;
            _creator = creator;
            _creatorUserId = creator.Id;
            _users.Add(_creator);
            _gameSettings = gameSettings;
        }

        public Guid Id { get; set; }

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }

        public IList<User> Users
        {
            get { return _users; }
            set { _users = value; }
        }

        public Guid CreatorUserId 
        {
            get { return _creatorUserId; }
        }

        public GameSettings GameSettings
        {
            get { return _gameSettings; }
            set { _gameSettings = value; }
        }

        public Guid GameId { get; set; } //moet dit nog gdn worden?

        public virtual int MaximumAmountOfUsers => DefaultMaximumAmountOfUsers;

        public bool GameHasStarted
        {
            get
            {
                return GameId != Guid.Empty;
            }
        }
    }
}