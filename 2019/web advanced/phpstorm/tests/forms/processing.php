<?php

require_once "src/faculty.php";

setcookie("name", $_GET['name'], time() + 600);
setcookie("backgroundColor", $_GET['background-color'], time() + 600);
$number = (int) $_GET['number'];

//$number = 5;
echo gettype($number) . "\n";
$result = 0;
if (gettype($number) === "integer" && $number > 0) {
    global $result;
    $result = faculty($number);
}
echo "faculty is: $result\n";
////header( "Location: ./display.php" );
