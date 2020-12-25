<?php

require_once 'vendor/autoload.php';

use \drawing\Line;
use \drawing\Point;
use \map\Road;

$line = new Line(new Point(1,2),new Point(3,4));
$road = new Road("Celestijnenlijn", $line);
print($road);