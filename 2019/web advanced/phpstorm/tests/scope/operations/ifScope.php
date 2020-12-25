<?php

$globalTest = 0; 
if (true) {
    $globalTest = "test";
    echo "nested global: " . $globalTest . "\n";
    $local = 1;
} else {
    $local = 2;
}
echo "global: " . $globalTest . "\n";
echo "local: " . $local;
