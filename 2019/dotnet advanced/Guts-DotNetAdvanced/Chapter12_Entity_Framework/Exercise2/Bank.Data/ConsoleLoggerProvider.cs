using System;

namespace Bank.Data
{
    internal class ConsoleLoggerProvider
    {
        private Func<object, object, bool> filter;
        private bool includeScopes;

        public ConsoleLoggerProvider(Func<object, object, bool> filter, bool includeScopes)
        {
            this.filter = filter;
            this.includeScopes = includeScopes;
        }
    }
}