<?php

require_once 'src/makeRow.php';

$array = makeRow(1, 10, 2);
echo "length: " . count($array) . "\n";
for ($i = 0; $i < count($array); $i++) {
    echo $array[$i];
}
