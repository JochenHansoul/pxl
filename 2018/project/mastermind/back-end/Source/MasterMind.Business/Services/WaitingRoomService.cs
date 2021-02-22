using System;
using MasterMind.Business.Models;
using MasterMind.Data.DomainClasses;
using MasterMind.Data.Repositories;
using System.Collections.Generic;
using System.Linq;
using MasterMind.Data;

namespace MasterMind.Business.Services
{
    public class WaitingRoomService : IWaitingRoomService
    {
        private IWaitingRoomRepository _waitingRoomRepository;

        public WaitingRoomService(IWaitingRoomRepository waitingRoomRepository)
        {
            _waitingRoomRepository = waitingRoomRepository;
        }

        public ICollection<WaitingRoom> GetAllAvailableRooms()
        {
            ICollection<WaitingRoom> allWaitingRooms = _waitingRoomRepository.GetAll();
            ICollection<WaitingRoom> availableWaitingRooms = new List<WaitingRoom>();

            foreach (WaitingRoom room in allWaitingRooms)
            {
                if (room.Users.Count < WaitingRoom.DefaultMaximumAmountOfUsers)
                {
                    availableWaitingRooms.Add(room);
                }
            }
            return availableWaitingRooms;
        }

        public WaitingRoom CreateRoom(WaitingRoomCreationModel roomToCreate, User creator)
        {
            CheckForDuplicateRoomName(roomToCreate.Name); //hier moet nog een try catch komen denk ik?
            WaitingRoom newRoom = new WaitingRoom(roomToCreate.Name,creator,roomToCreate.GameSettings);

            _waitingRoomRepository.Add(newRoom);
            return newRoom;
        }

        public WaitingRoom GetRoomById(Guid id)
        {
            return _waitingRoomRepository.GetById(id);
        }

        public bool TryJoinRoom(Guid roomId, User user, out string failureReason)
        {
            try
            {
                WaitingRoom roomToJoin = _waitingRoomRepository.GetById(roomId);

                CheckIfRoomExists(roomToJoin);
                CheckIfRoomIsFull(roomToJoin);
                CanUserJoinRoom(roomToJoin, user);
                roomToJoin.Users.Add(user);
                failureReason = null;
                return true;              
            } 
            catch (ApplicationException e)
            {
                failureReason = e.Message;
                return false;
            }
        }

        public bool TryLeaveRoom(Guid roomId, User user, out string failureReason)
        {
            try
            {
                WaitingRoom roomToLeave = _waitingRoomRepository.GetById(roomId);

                CheckIfRoomExists(roomToLeave);
                CanUserLeaveRoom(roomToLeave, user);
                if (user.Id == roomToLeave.CreatorUserId)
                {
                    _waitingRoomRepository.DeleteById(roomToLeave.Id);
                }
                else
                {
                    for (int i = 0; i < roomToLeave.Users.Count; i++)
                    {
                        if (roomToLeave.Users[i].UserName.Equals(user.UserName))
                        {
                            roomToLeave.Users.RemoveAt(i);
                        }
                    }     
                }
                failureReason = null;
                return true;
            }
            catch (ApplicationException e)
            {
                failureReason = e.Message;
                return false;
            }
        }

        private void CheckIfRoomExists(WaitingRoom room)
        {
            if (room == null)
            {
                throw new ApplicationException("The room you are trying to join does not exist");
            }
        }

        private void CheckForDuplicateRoomName(string roomName) //nog een try catch schrijven
        {
            bool duplicateName = _waitingRoomRepository.GetAll().Any(n => n.Name == roomName);
            if (duplicateName)
            {
                throw new ApplicationException("The name of the room is not unique!"); 
            }
        }

        private void CheckIfRoomIsFull(WaitingRoom room) //nog een try catch schrijven
        {
            if (room.Users.Count == WaitingRoom.DefaultMaximumAmountOfUsers)
            {
                throw new ApplicationException("The room you tried to join is full"); 
            }
        }

        private bool CheckIfUserIsInRoom(WaitingRoom room, User user)
        {
            return room.Users.Any(n => n.UserName.Equals(user.UserName));
        }

        private void CanUserJoinRoom(WaitingRoom room, User user)
        {
            if (CheckIfUserIsInRoom(room, user))
            {
                throw new ApplicationException($"{user.NickName} is already in the room");
            }
        }

        private void CanUserLeaveRoom(WaitingRoom room, User user)
        {
            if (!CheckIfUserIsInRoom(room, user))
            {
                throw new ApplicationException($"{user.NickName} is not a part of this room."); 
            }
        }
    }
}