<?php

declare(strict_types=1);

$s = readline("enter \"true\" or \"false\": ");
$b = (strtolower($s) == "true") ? true : false;

echo "amount of globals before: " . count($GLOBALS) . "\n";
if ($b) {
    $var1 = 1;
} else {
    $var2 = 2;
    $var3 = 3;
}
echo "amount of globals after: " . count($GLOBALS) . "\n";
