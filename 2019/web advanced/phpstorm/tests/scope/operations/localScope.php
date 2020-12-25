<?php

$i = 0;
$sum = 0;
for ($i = 0; $i < 2; $i++) {
    $localA = 0;
    $localB = "local";
}
echo "global: $i\n"; // prints 2
echo "local A: $localA\n";
echo "local B: $localB\n";

// oplossing: de variabele in de lus $i1 noemen en na de lus unsetten
