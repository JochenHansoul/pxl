using System;
using System.Collections.Generic;
using System.Text;

namespace RedDevils
{
    public class Player
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string ImageURL { get; set; }
        public string FullName
        {
            get
            {
                return $"{FirstName} {LastName}";
            }
        }
    }
}
