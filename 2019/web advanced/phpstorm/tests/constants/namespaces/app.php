<?php

declare(strict_types=1);

use const src\Constants\NUMBER;
use const src\Constants\NUMBERS;
use const src\OtherConstants\NUMBER as NUMBER2;

require_once "src/Constants/NUMBER.php";
require_once "src/Constants/NUMBERS.php";
require_once "src/OtherConstants/NUMBER.php";

echo NUMBER . "\n";
echo NUMBER2 . "\n";
echo NUMBERS["one"] . "\n";
