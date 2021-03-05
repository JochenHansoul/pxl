using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Bank.Data.DomainClasses
{
    public class City
    {
        public int ZipCode { get; set; }
        public string Name { get; set; }
        public List<Customer> Customers { get; set; }
    }
}