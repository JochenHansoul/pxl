<?php

$a = ['a', 'b', 'c'];
$tag = [];
foreach($a as $e) {
    //$tag[] = ".$e";
    $var1 = "loal var";
}
echo "local element: $e\n"; // prints c
echo "local var1: $var1\n";
//print_r($tag);

for($i = 0; $i < 2; $i++) {
    // empty
}
echo "Local i: $i\n"; // prints 2
/*for($i = 0; $i < 3; $i++) {
    echo "$i\n";
}*/
