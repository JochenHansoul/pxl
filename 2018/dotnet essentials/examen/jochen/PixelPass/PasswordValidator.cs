using System;
using System.Windows;

namespace PixelPass
{
    public class PasswordValidator
    {
        private const int MinimumLength = 5;
        private const int AverageLength = 10;

        private const string alfabetSmallCaps = "abcdefghijklmnopqrstuvwxyz";
        private const string alfabetUpperCaps = "ABCEDFGHIJKLMNOPQRSTUVWXYZ";
        private const string digits = "0123456789";

        public static Strength CalculateStrength(string password)
        {
            if (password != null)
            {
                int passwordLength = password.Length;
                if (passwordLength >= MinimumLength)
                {
                    char[] characters = password.ToCharArray();
                    bool containsLower = false, containsUpper = false, containsNumber = false;
                    int counter = 0;
                    while (counter < passwordLength && !(containsNumber && containsUpper && containsLower))
                    {
                        if (Char.IsLower(characters[counter]))
                        {
                            containsLower = true;
                        }
                        else if (Char.IsUpper(characters[counter]))
                        {
                            containsUpper = true;
                        }
                        else if (Char.IsDigit(characters[counter]))
                        {
                            containsNumber = true;
                        }
                        counter++;
                    }
                    if (containsNumber && containsUpper && containsLower && passwordLength > AverageLength) return Strength.Strong;
                    int strengthPassword = 0;
                    foreach (bool aBool in new bool[] { containsLower, containsUpper, containsNumber })
                    {
                        if (aBool) strengthPassword++;
                    }
                    if (strengthPassword >= 2) return Strength.Average;
                }
            }
            return Strength.Weak;

            //int passwordLength = password.Length;
            //if (password != null && passwordLength <= MinimumLength) // >= MinimumLength
            //{
            //    bool containsLower = false, containsUpper = false, containsNumber = false;
            //    password.Contains("a");
            //    int counter = 0;
            //    char[] characters = password.ToCharArray();
            //    while (counter < password.Length && !(containsLower && containsUpper && containsNumber))
            //    {
            //        if (Char.IsDigit(characters[counter]))
            //        {
            //            containsNumber = true;
            //        }
            //        else if (Char.IsLower(characters[counter]))
            //        {
            //            containsLower = true;
            //        }
            //        else if (Char.IsUpper(characters[counter]))
            //        {
            //            containsUpper = true;
            //        }
            //        counter++;
            //    }
            //    if (containsLower && containsUpper && containsNumber)
            //    {
            //        return Strength.Strong;
            //    }
            //    bool[] containsBool = { containsLower, containsUpper, containsNumber };
            //    int strengthPassword = 0;
            //    foreach (bool aBool in containsBool)
            //    {
            //        strengthPassword++;
            //    }
            //    if (strengthPassword == 3 && password.Length > AverageLength)
            //    {
            //        return Strength.Strong;
            //    }
            //    else if (strengthPassword == 2) // >= 2
            //    {
            //        return Strength.Average;
            //    }
            //}
            //return Strength.Weak;
        }
    }

    public enum Strength
    {
        Weak,
        Average,
        Strong
    }
}


//int containsLower = 0, containsUpper = 0, containsDigit = 0;
//int counter = 0;
//while (counter < digits.Length && containsDigit == 0)
//{
//    if (password.Contains(Convert.ToString(digits[counter])))
//    {
//        containsDigit = 1;
//    }
//    else if (password.Contains(Convert.ToString(alfabetSmallCaps[counter])))
//    {
//        containsLower = 1;
//    }
//    else if (password.Contains(Convert.ToString(alfabetUpperCaps[counter])))
//    {
//        containsUpper = 1;
//    }
//    counter++;
//}
//while (counter < alfabetSmallCaps.Length && !(containsLower == 0 && containsUpper == 0))
//{
//    if (password.Contains(Convert.ToString(alfabetSmallCaps[counter])))
//    {
//        containsLower = 1;
//    }
//    else if (password.Contains(Convert.ToString(alfabetUpperCaps[counter])))
//    {
//        containsUpper = 1;
//    }
//    counter++;
//}
//int passwordStrength = containsLower + containsUpper + containsDigit;
//if (passwordLength > AverageLength && passwordStrength == 3) return Strength.Strong;
//if (passwordStrength >= 2) return Strength.Average;