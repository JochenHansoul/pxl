<?php

$s = "word1\nword2\nword3\n";
echo $s;
$newString = str_replace("\n", "<br/>", $s);
echo $newString;
