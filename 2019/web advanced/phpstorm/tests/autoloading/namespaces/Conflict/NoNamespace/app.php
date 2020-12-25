<?php

require_once "src/Dir1/Foo.php";
//require_once "src/Dir2/Foo.php"; // Cannot declare class Foo, because the name is already in use in Dir2

$o = new Foo();
echo $o . "\n";
