<?php

require_once 'vendor/autoload.php';

use Date\Date;

$date = Date::make($_GET["year"], $_GET["month"], $_GET['day']);
$date->print();
echo "<br/>";
$date->printMonth();
