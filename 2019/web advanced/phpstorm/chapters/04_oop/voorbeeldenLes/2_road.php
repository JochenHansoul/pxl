<?php
require_once 'src/drawing/Point.php';
require_once 'src/drawing/Line.php';
require_once 'src/map/Road.php';

use \drawing\Line;
use \drawing\Point;
use \map\Road;

$line = new Line(new Point(1,2), new Point(3,4));
$road = new Road("Celestijnenlijn", $line);
print($road);
