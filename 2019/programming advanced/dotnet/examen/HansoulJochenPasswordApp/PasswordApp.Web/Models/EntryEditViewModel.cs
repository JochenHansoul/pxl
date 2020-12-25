using System.ComponentModel.DataAnnotations;

namespace PasswordApp.Web.Models
{
    public class EntryEditViewModel
    {
        public string Password { get; set; }

        public string Url { get; set; }
    }
}