<?php

//declare(strict_types=1);

require_once "src/StrictClass.php";

$o = new StrictClass("1");
echo $o->getValue() . "\n";
