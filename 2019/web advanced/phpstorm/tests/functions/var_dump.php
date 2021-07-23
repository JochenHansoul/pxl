<?php

var_dump('' . true); // print de lengte van de string gevolgd door de string: "string(1) "1"
//var_dump('' . true . '' . false . '' . true); // false wordt niet geprint
//var_dump('' . true . '' . true . '' . true);

// multiple variables
echo "\nmultiple variables:\n";
$var1 = "hello";
$var2 = "world";
var_dump($var1, $var2);

echo "\nvar export:\n";
//var_export($var1, $var2); // does only work with one variable
var_export($var1); // also doenst print a new line
