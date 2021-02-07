<?php

const C_NUMBER = 10;
const C_DOUBLE = C_NUMBER + 1.1;
const C_STRING = "a" . "b";
const C_INTEGER = true + false;
const E = 10 . "a";
const F = 10.1 - C_DOUBLE;
const G = 10 . C_DOUBLE; // kan wel worden geconcateneerd met .
const H = G < C_DOUBLE;
const I = H < 10;
const J = H ?? C_DOUBLE;
// strings en nummers kunnen niet opgeteld worden met const
//const K = "a" + 5;
//const L = C_STRING + C_DOUBLE;

echo gettype(C_DOUBLE) . "\n";
echo gettype(C_INTEGER) . "\n";

define('FOO', 'bar');
echo FOO . "\n";
//echo $_GET["FOO"]; // PHP Notice:  Undefined index: FOO
