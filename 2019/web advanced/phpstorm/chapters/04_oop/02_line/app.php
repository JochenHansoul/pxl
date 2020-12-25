<?php

require_once 'vendor/autoload.php';

use drawing\Point;
use drawing\Line;

// point
try{
    $point = new Point(111,1);
} catch (InvalidArgumentException $e) {
    echo $e->getMessage();
}
echo "<br/>";

// line
$line = new Line();
$line->addPoint(Point::makePointAtOrigin());
$line->addPoint(Point::makePointAt(1,2));
echo $line;