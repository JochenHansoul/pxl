using System.Collections.Generic;
using System.Linq;

namespace MasterMind.Data.DomainClasses
{
    public class GuessResult
    {
        private int _correctColorAndPositionAmount;
        private int _correctColorAmount;
        private string[] _colors;

        public string[] Colors
        {
            get { return _colors; }
            set { _colors = value; }
        }

        public virtual int CorrectColorAndPositionAmount
        {
            get { return _correctColorAndPositionAmount; } //must be virtual for some automated test to work!
            set { _correctColorAndPositionAmount = value; }
        }

        public virtual int CorrectColorAmount => _correctColorAmount; //must be virtual for some automated test to work!

        public GuessResult(string[] colors) // user
        {
            _colors = colors;
            _correctColorAndPositionAmount = 0;
            _correctColorAmount = 0;
        }

        public void Verify(string[] codeToGuess)
        {
            bool[] notCorrectPlace = new bool[codeToGuess.Length];
            bool[] notCorrectColor = new bool[codeToGuess.Length];
            string computerColor;

            for (int i = 0; i < codeToGuess.Length; i++)
            {
                notCorrectPlace[i] = true;
                notCorrectColor[i] = true;
            }

            // juiste plaats correct
            for (int i = 0; i < codeToGuess.Length; i++)
            {
                computerColor = _colors[i];
                if (computerColor.Equals(codeToGuess[i]))
                {
                    _correctColorAndPositionAmount++;
                    notCorrectPlace[i] = false;
                    notCorrectColor[i] = false;
                }
            }

            // juiste kleur correct
            for (int j = 0; j < codeToGuess.Length; j++)
            {
                int codeGuessIndex = 0;
                bool colorFound = false;
                computerColor = _colors[j];

                // elke kleur individueel controleren 
                if (notCorrectPlace[j])
                {

                    while(codeGuessIndex < codeToGuess.Length && !colorFound)
                    {
                        if (computerColor.Equals(codeToGuess[codeGuessIndex]) && notCorrectColor[codeGuessIndex])
                        {
                            _correctColorAmount++;
                            notCorrectColor[codeGuessIndex] = false;
                            colorFound = true;
                        }

                        codeGuessIndex++;
                    }
                }
            }
        }
    }
}