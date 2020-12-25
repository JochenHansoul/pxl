<?php

require_once "src/autoload.php";

$o = new Foo();
echo "\n";
$ob = new Bar();
echo "\n";

//echo SYMBOL; // PHP Warning:  Use of undefined constant SYMBOL - assumed 'SYMBOL'
//fun1(); // PHP Fatal error:  Uncaught Error: Call to undefined function fun1()

// subautoloading
$o = new FooD1();
echo "\n";
//$o = new FooD2(); // PHP Fatal error:  Uncaught Error: Class 'FooD2' not found in
//echo "\n";
