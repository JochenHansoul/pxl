using System;
using PasswordApp.Data;

namespace PasswordApp.Test.Builders
{
    public class Builder
    {
        private readonly  _;

        public Builder()
        {
            _ = new 
            {
                Id = Guid.NewGuid(),
                UserName = Guid.NewGuid().ToString(),
                Password = Guid.NewGuid().ToString(),
                Title = Guid.NewGuid().ToString(),
                UserId = Guid.NewGuid()
            };
        }

        public Builder WithPassword(string password)
        {
            _.Password = password;
            return this;
        }

        public  Build()
        {
            return _;
        }
    }
}