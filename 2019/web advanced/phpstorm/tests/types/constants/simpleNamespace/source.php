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
const A = 10 + 1.1;
const B = "a" . "b";
const D = true + false;
const E = 10 . "a";
const F = 10.1 - A;
const G = 10 . A;
const H = G < A;
const I = H < 10;
const J = H ?? A;
// strings en nummers kunnen niet opgeteld worden met const
//const K = "a" + 5;
//const L = B + A;

echo gettype(A) . "\n";
echo gettype(D);

$var1 = 1;
unset($var1);
//unset(A); kan niet unsetten