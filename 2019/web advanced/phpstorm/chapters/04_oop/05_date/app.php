<?php

require_once "vendor/autoload.php";

use Date\Date;

try {
    $date = Date::make(2020, 2, 29);
    $date->print();
    echo "\n";
    $date->printMonth();
    echo "\n";
    $date2 = $date->changeMonth(12);
    $date2->print();
} catch (DateException $e) {
    echo $e->getMessage();
}
