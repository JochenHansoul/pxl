<?php

DEFINE("CONST1", 1);
const MIN_VALUE = 0.1;

//echo CONST1;
function printOuterConstant() {
    print CONST1 . "\n";
    print MIN_VALUE . "\n";
}

printOuterConstant();
echo "\n";

define('FOO', 'bar');
$testString = sprintf('This is a %s string', FOO);
echo $testString;

//echo $_GET["FOO"];
