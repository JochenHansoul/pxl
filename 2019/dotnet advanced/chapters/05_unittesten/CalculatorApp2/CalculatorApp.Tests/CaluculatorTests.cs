using CalculatorApp2;
using NUnit.Framework;

namespace CalculatorApp.Tests
{
    [TestFixture]
    public class CalculatorTests
    {
        //private Calculator calculator;

        //[SetUp]
        //public void Setup()
        //{
        //    calculator = new Calculator(); // voor elke test uitgevoerd
        //}

        [TestCase(1, 2, 3)]
        [TestCase(5, 5, 10)]
        [TestCase(-5, -10, -15)]
        [TestCase(1000, 2000, 3000)]
        public void ShouldAddTwoNumber(int firstNum, int secondNum, int result)
        {
            //arrange (eerst instantie maken)
            var sut = new Calculator();

            //act (methode aanroepen)
            int som = sut.Add(firstNum, secondNum);

            //assert (gaat uitkomst aanroepen methode verg met hetgeen verw
            Assert.That(som, Is.EqualTo(result));
        }

        [Test]
        [Category("first Category")]
        public void ShouldMultiplyTwoNumbers()
        {
            var sut = new Calculator();

            int product = sut.Multiply(1, 2);

            Assert.That(product, Is.EqualTo(2));
        }
    }
}
