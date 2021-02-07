<?php

DEFINE("CONST1", 1);
const MIN_VALUE = 0.1;

function printOuterConstant() {
    print CONST1 . "\n";
    print MIN_VALUE . "\n";
}

printOuterConstant();
