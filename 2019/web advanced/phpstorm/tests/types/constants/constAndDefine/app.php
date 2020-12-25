<?php

require_once "src/Classes/Worker.php";
require_once "src/Constants/CONSTANT.php";
require_once "src/OtherConstants/CONSTANT.php";

use Classes\Worker;

use const Constants\NUMBER;
use const OtherConstants\NUMBER as NUMBER2;

$worker = new Worker();
//echo var_dump($worker) . "\n";
echo var_dump(NUMBER) . "\n";
echo var_dump(NUMBER2) . "\n";