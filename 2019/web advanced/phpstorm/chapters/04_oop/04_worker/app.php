<?php

require_once "vendor/autoload.php";

use Tools\Broom;
use Workers\Handyman;

$broom = new Broom();
$handyMan = new Handyman($broom);
$handyMan->work();
echo "\n";
