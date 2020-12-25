using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using PasswordApp.Data;
using PasswordApp.Web.Models;
using PasswordApp.Web.Services.Contracts;

namespace PasswordApp.Web.Controllers
{
    public class EntriesController : Controller
    {
        public Task<IActionResult> Index()
        {
            //TODO: implement the test for this method and make it green
            throw new NotImplementedException();
        }

        public IActionResult Edit(Guid id)
        {
            //TODO: implement the test for this method and make it green
            throw new NotImplementedException();
        }

        public IActionResult Edit(Guid id, EntryEditViewModel model)
        {
            //TODO: use model binding techniques to validate the input model
            //TODO: update using the repository and send the user to the overview (of entries) page.
            throw new NotImplementedException();
        }
    }
}