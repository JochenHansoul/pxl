<?php

$str = "SELECT * FROM table WHERE id in (1, 2, 3, 4, 5, ";
echo substr_replace($str, ");", -2) . "\n";
