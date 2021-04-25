<?php

require_once "src/IntClass.php";

$varEmpty;
//echo $varEmpty; //PHP Notice:  Undefined variable: varEmpty
$varNull = null;
echo "null: ({$varNull})\tvalue: " . gettype($varNull) ."\n";

echo "0: " . gettype(0) . "\n";
$varInt = 0;
echo "varInt: " . gettype($varInt) . "\n";

// class
//$object = new Object();
//echo "object: $object type: " . gettype($object) . "\n";
$o = new IntClass(1);
echo gettype($o) . "\n";
echo "getValue(): " . $o->getValue() . " type: " . gettype($o->getValue());
