using System;
using Moq;
using NUnit.Framework;
using PasswordApp.Data;
using PasswordApp.Data.Repositories;
using PasswordApp.Test.Builders;
using PasswordApp.Web.Services;
using PasswordApp.Web.Services.Contracts;

namespace PasswordApp.Test
{
    public class EntryServiceTests
    {
        [Test]
        public void Update_ShouldEncryptThePasswordAndUpdateUsingTheRepository()
        {
            Assert.Fail("TODO: implement this test");
            //Tip: the service will need an a repository to retrieve entries and a service to encrypt/decrypt passwords.
            //Tip: you can make use of the EntryBuilder class in the 'Builders' folder.
            //Tip: a string representation of the Id of the Entry should be used as 'salt' to encrypt the password.
        }
    }
}