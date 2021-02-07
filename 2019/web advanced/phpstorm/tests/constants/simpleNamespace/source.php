<?php

namespace NewNamespace;

class NewClass
{
    const CONST1 = "a";
    //define("S", 5);
}

const OUTER_CONSTANTS = "5";

function newFunction()
{
    //const FUN = "d";
    define ("FUN", "yeay!");
    echo OUTER_CONSTANTS . "\n";
}
newFunction();

const NEW_CONSTANT = 10;
const NUMBER = 10 + 1.1;
const STRING_C = "a" . "b";
const D = true + false;
const E = 10 . "a";
const F = 10.1 - NUMBER;
const G = 10 . NUMBER; // kan wel worden geconcateneerd met .
const H = G < NUMBER;
const I = H < 10;
const J = H ?? NUMBER;
// strings en nummers kunnen niet opgeteld worden met const
//const K = "a" + 5;
//const L = STRING_C + NUMBER;

echo gettype(NUMBER) . "\n";
echo gettype(D) . "\n";

$var1 = 1;
unset($var1);
//unset(A); kan niet unsetten
