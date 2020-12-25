﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Dummy.Web.Controllers.Api
{
    [Route("api/[controller]")]
    [ApiController]
    public class DummyApiController : ControllerBase
    {
        public IActionResult DoStuff()
        {
            return Conflict();
        }
    }
}