<?php

$varGlobal;
if (true) {
    $varLocalTrue = "hello world";
} else {
    $varLocalFalse = "goodbye world";
}
echo $varGlobal . "\n"; // undefined var
echo $varLocalTrue . "\n";
echo $varLocalFalse . "\n"; // undefined var
