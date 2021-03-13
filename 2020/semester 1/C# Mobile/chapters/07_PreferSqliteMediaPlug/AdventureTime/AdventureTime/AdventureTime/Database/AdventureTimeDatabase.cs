using System.Collections.Generic;
using System.Threading.Tasks;
using AdventureTime.Models;
using SQLite;

namespace AdventureTime.Database
{
    public class AdventureTimeDatabase
    {
        readonly SQLiteAsyncConnection _database;

        public AdventureTimeDatabase(string path)
        {
            _database = new SQLiteAsyncConnection(path);
            _database.CreateTableAsync<Character>().Wait(); // Wait() niet vergeten
        }

        public Task<List<Character>> GetCharactersAsync()
        {
            return _database.Table<Character>().ToListAsync();
        }

        // Made myself
        public Task<Character> GetCharacterWithIdAsync(int id)
        {
            return _database.Table<Character>().Where(o => o.ID == id).FirstOrDefaultAsync();
        }

        public Task<int> SaveCharacterAsync(Character character)
        {
            return (character.ID == 0) ? _database.InsertAsync(character) : _database.UpdateAsync(character);
        }

        public Task<int> DeleteCharacterAsync(Character character)
        {
            return _database.DeleteAsync(character);
        }
    }
}
