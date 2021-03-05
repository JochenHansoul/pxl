using Lottery.Business.Interfaces;
using Lottery.Data.Interfaces;
using Lottery.Domain;
using System;
using System.Collections;
using System.Collections.Generic;

namespace Lottery.Business
{
    public class DrawService : IDrawService
    {
        private IDrawRepository _drawRepository;
        private Random random = new Random();

        public DrawService(IDrawRepository drawRepository)
        {
            _drawRepository = drawRepository;
        }

        public void CreateDrawFor(LotteryGame lotteryGame)
        {
            IList<int> randomnumbers = new List<int>();
            int counter = 0;
            while (counter < lotteryGame.NumberOfNumbersInADraw)
            {
                int number = random.Next(1, lotteryGame.MaximumNumber);
                if (!randomnumbers.Contains(number))
                {
                    randomnumbers.Add(number);
                    counter++;
                }
            }
            _drawRepository.Add(lotteryGame.Id, randomnumbers);
        }
    }
}
