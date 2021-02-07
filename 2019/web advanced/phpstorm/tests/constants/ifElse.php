<?php

const CONST_ONE = (false) ? "true" : 1;
echo CONST_ONE . "\n";

if (true) {
    define("LOCAL_CONSTANT", (true) ? "true" : "false");
    //const LOCAL_MODERN_CONSTANT = "value"; // PHP Parse error:  syntax error, unexpected 'const
}
