using Moq;
using NUnit.Framework;

namespace Dummy.Web.Tests
{
    internal interface IVolume
    {
        void Mute();
    }

    public class DummyTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void DoTest()
        {
            var volumeMock = new Mock<IVolume>();
            Assert.Fail("Dummy fail");
        }
    }
}