<?php

$array = [
	"key1" => "value 1",
	"key2" => "value 2",
	"key3" => "value 3"
];

$arraySameKeys = [
	"key" => "value 1",
	"key" => "value 2",
	"key" => "value 3"
];
print_r($array) . "\n";
print_r(array_values($array)) ."\n";

echo "same keys:\n";
print_r(array_values($arraySameKeys));
