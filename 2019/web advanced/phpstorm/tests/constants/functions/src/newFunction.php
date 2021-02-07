<?php

namespace NewNamespace;

const OUTER_CONSTANT = 1;

function newFunction()
{
    //const FUN = "d";
    define ("FUN", "yeay!");
    echo OUTER_CONSTANT . "\n";
}
newFunction();
