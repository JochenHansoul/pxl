<?php

require_once 'src/drawing/Point.php';
require_once 'src/drawing/Line.php';

use \drawing\Line;
use \drawing\Point;

// points
$p = Point::makeOrigin();
print($p . "\n");
print("amount: " . Point::getCount() . "\n");
$p = null;
print("amount after null: " . Point::getCount() . "\n");
$p2 = new Point(1,2);

// lines
$line = new Line(new Point(1,2), new Point(3,4));
print($line);