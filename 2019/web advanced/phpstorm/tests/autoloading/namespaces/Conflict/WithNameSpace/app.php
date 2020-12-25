<?php

require_once "src/Dir1/Foo.php";
require_once "src/Dir2/Foo.php"; // Cannot declare class Foo, because the name is already in use in Dir2

use Dir1\Foo;
use Dir2\Foo as FooOther;

//$o = new Dir1\Foo();
$o = new Foo();
echo $o . "\n";

$o2 = new FooOther();
echo $o2 . "\n";
