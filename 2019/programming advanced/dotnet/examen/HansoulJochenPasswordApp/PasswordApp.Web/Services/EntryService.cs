using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using PasswordApp.Data;
using PasswordApp.Data.Repositories;
using PasswordApp.Web.Services.Contracts;

namespace PasswordApp.Web.Services
{
    public class EntryService : IEntryService
    {
        public Entry GetById(Guid id)
        {
            //TODO: retrieve the entry from the repository, decrypt the password and return the entry.
            //You should use the 'Id' of the entry as the salt for decrypting the password.
            throw new NotImplementedException();
        }

        public void Update(Guid id, string password, string url)
        {
            //TODO: implement the test for this method and make it green
            //You should use the 'Id' of the entry as the salt for encrypting the password.
        }

        public Task<IReadOnlyList<Entry>> GetEntriesOfUserAsync(Guid userId)
        {
            //TODO: retrieve the entries using the 'GetEntriesOfUserAsync' method of the repository and just return the retrieved entries.
            throw new NotImplementedException();
        }
    }
}