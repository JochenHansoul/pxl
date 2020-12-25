using System;
using System.Collections.Generic;
using System.Security.Claims;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Moq;
using NUnit.Framework;
using PasswordApp.Data;
using PasswordApp.Test.Builders;
using PasswordApp.Web.Controllers;
using PasswordApp.Web.Models;
using PasswordApp.Web.Services.Contracts;

namespace PasswordApp.Test
{
    public class EntriesControllerTests
    {
        private static readonly Random RandomGenerator = new Random();
        private Guid _userId;

        [Test]
        public void Index_ShouldRetrieveEntriesOfUserAndConvertThemToListItemModels()
        {
            //TODO: implement the following test scenario
            //  * Create a list that contains a random number of entries (minimal 1 entry and maximal 10 entries). Tip: use the EntryBuilder class in the "Builders" folder.
            //  * Setup a mock of IEntryService that always returns the list of entries you created when GetEntriesOfUserAsync is executed.
            //  * Setup a mock of IConverter.
            //    Tip: the default behavior of the fake will be enough.
            //  * Instantiate an EntriesController that uses the mocks. Use the CreateContextWithLoggedInUser helper method in this class to fake a logged in user.
            //  * Execute the Index action and verify:
            //      - A ViewResult should be returned
            //      - The service should be called one time with the id of the logged in user.
            //      - The converter should be called once for each entry returned by the service to convert the Entry to an EntryListItemViewModel.
            //        Tip: Use 'It.IsIn<Entry>(...)'. Make sure the generic argument (<Entry>) is provided when you use this method.
            //      - The model of the ViewResult should be an IReadOnlyList of EntryListItemViewModel and should have the same amount of items as the amount of entries returned by the service.

            // Production code tips: 
            //  * Tip: Inspecting the CreateContextWithLoggedInUser helper method will give you insight in what claim can be retrieved to get the id of the user.
            //  * Tip: A string can be converted to a Guid with the Guid.Parse method.
            //  * Tip: List<T> implements IReadOnlyList<T>

        }

        [Test]
        public void Edit_Get_ShouldRetrieveTheEntryAndConvertItToAnEditViewModel()
        {
            Assert.Fail("TODO: implement this test");
        }

        private ControllerContext CreateContextWithLoggedInUser()
        {
            _userId = Guid.NewGuid();
            var context = new ControllerContext
            {
                HttpContext = new DefaultHttpContext
                {
                    User = new ClaimsPrincipal(new ClaimsIdentity(new[] { new Claim(ClaimTypes.NameIdentifier, _userId.ToString()) }))
                }
            };
            context.HttpContext.User.AddIdentity(new ClaimsIdentity());
            return context;
        }
    }
}