using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using MasterMind.Data.DomainClasses;

namespace MasterMind.Data.Repositories
{
    public class InMemoryWaitingRoomRepository : IWaitingRoomRepository
    {

        private ConcurrentDictionary<Guid, WaitingRoom> _internalDictionary; 

        public InMemoryWaitingRoomRepository()
        {
            _internalDictionary = new ConcurrentDictionary<Guid, WaitingRoom>();
        }

        public WaitingRoom Add(WaitingRoom newWaitingRoom)
        {
            Guid id = Guid.NewGuid();
            newWaitingRoom.Id = id;
            _internalDictionary.TryAdd(newWaitingRoom.Id, newWaitingRoom);
            return newWaitingRoom;
        }

        public WaitingRoom GetById(Guid id)
        {
            if(!_internalDictionary.TryGetValue(id, out WaitingRoom room))
            {
                throw new DataNotFoundException();
            }
            return room;
        }

        public ICollection<WaitingRoom> GetAll()
        {
            ICollection<WaitingRoom> rooms = _internalDictionary.Values;

            return rooms;
        }

        public void DeleteById(Guid id)
        {
            _internalDictionary.TryRemove(id, out WaitingRoom room);
        }
    }
}