<?php

// nested array (just an example, this should have been an ojbect)
$stock = [
  	['name' => 'Phone', 'qty' => 0],
  	['name' => 'Notebook', 'qty' => 1],
  	['name' => 'SDD Drive', 'qty' => 0],
 	['name' => 'HDD Drive', 'qty' => 3]
];
//echo "${stock[0]['name']} ${stock[0]['qty']}";
// error: PHP Parse error:  syntax error, unexpected '[', expecting '}' in
echo "{$stock[0]['name']} {$stock[0]['qty']}";
