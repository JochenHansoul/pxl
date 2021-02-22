using System;
using System.Collections.Concurrent;
using MasterMind.Data.DomainClasses;

namespace MasterMind.Data.Repositories
{
    public class InMemoryGameRepository : IGameRepository
    {
        private ConcurrentDictionary<Guid, IGame> _internalDictionary;

        public InMemoryGameRepository()
        {
            _internalDictionary = new ConcurrentDictionary<Guid, IGame>();
        }

        public IGame Add(IGame newGame)
        {
            Guid id = Guid.NewGuid();
            newGame.Id = id;
            _internalDictionary.TryAdd(id, newGame);
            
            return newGame;
        }

        public IGame GetById(Guid id)
        {
            IGame game;
            if(!_internalDictionary.TryGetValue(id, out game))
            {
                throw new DataNotFoundException();
            }
                
            return game;
        }

        public void DeleteById(Guid id)
        {
            _internalDictionary.TryRemove(id, out IGame game);
        }
    }
}