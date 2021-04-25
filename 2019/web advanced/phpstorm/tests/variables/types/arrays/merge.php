<?php

const FRUITS = [
    "a" => "apple",
    "b" => "banana",
    "c" => "citron"
];
const FURNITURE = [
    "1" => "chair",
    "2" => "table",
    "3" => "sofa"
];

foreach(FRUITS as $v) {
    echo $v . "\n";
}
foreach(array_keys(FRUITS) as $v) {
    echo $v . "\n";
}
foreach(array_values(FRUITS) as $v) {
    echo $v . "\n";
}

$comb = array_merge(FRUITS, FURNITURE);
echo "combined:\n";
foreach($comb as $v) {
    echo $v . "\n";
}
