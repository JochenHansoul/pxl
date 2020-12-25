using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PixelPass
{
    public class AccountInfoCollection : IAccountInfoCollection
    {
        //public List<AccountInfo> AccountInfos => throw new NotImplementedException();

        public string Name { get; set; }
        public List<AccountInfo> AccountInfos { get; }

        public AccountInfoCollection(string name)
        {
            Name = name;
            AccountInfos = new List<AccountInfo>();
        }

        public void AddAccountInfo(AccountInfo accountInfo)
        {
            AccountInfos.Add(accountInfo);
        }
    }
}
