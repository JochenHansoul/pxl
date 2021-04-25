<?php

// defining vars with curly braces
//${var2} = "hello var2";
/*
output:
PHP Warning:  Use of undefined constant var2 - assumed 'var2' (this will throw an Error in a future version of PHP) in /home/jochenhansoul/projects/2019/web advanced/phpstorm/chapters/03_intro/tests/curly-bracets.php on line 4
PHP Stack trace:
PHP   1. {main}() /home/jochenhansoul/projects/2019/web advanced/phpstorm/chapters/03_intro/tests/curly-bracets.php:0
*/
//{$var3} = "hello var3";
/*
output:
PHP Parse error:  syntax error, unexpected '}' in /home/jochenhansoul/projects/2019/web advanced/phpstorm/chapters/03_intro/tests/curly-bracets.php on line 5
*/

// strings with curly braces
$var1 = "hello world";
echo "no curly braces: $var1\n";
echo "with inner curly braces: ${var1}\n";
echo "with outer curly braces: {$var1}\n";
echo "with outer curly braces and backspace: {\$var1}\n";

// arrays
$array = ['hello world'];
echo "array with inner: ${array[0]}\n";
echo "array with outer: {$array[0]}\n";

// class methods
class Square
{
    function area()
    {
        return 49;
    }
}

$squire = new Square();
//echo "method withouth: $squire->area()";
//echo "method with inner curly braces: ${squire->area()}";
echo "method with outer curly braces: {$squire->area()}";
