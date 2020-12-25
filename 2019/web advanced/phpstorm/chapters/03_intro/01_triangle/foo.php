<?php

use Classes\Foo;

require_once "vendor/autoload.php";

$f = new Foo("Dave");
echo $f->toString() . "\n";
