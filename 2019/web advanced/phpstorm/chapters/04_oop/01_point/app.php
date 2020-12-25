<?php

require_once 'src/classes/Point.php';
require_once 'src/classes/Color.php';
require_once 'src/classes/ColoredPoint.php';

use classes\Point;
use classes\Color;
use classes\ColoredPoint;

/*
$point1 = new Point(1,2);
print ($point1 . "\n");
$point2 = new Point(5,11);
print ($point2 . "\n");
$distance = $point1->calculateDistance($point2);
print ($distance);
*/

$point1 = new Point(1, 1);

$pointAssign = $point1;
//$pointAssign->setX(2);

$pointReference = & $point1;
//$pointReference->setX(3);

$point1->setX(5);
//$pointReference->__set("x", 4);

//var_dump($point1);
//var_dump($pointAssign);
//var_dump($pointReference);

$color = Color::makeColor(0xFF0000);
echo $color->getRgb();
echo "<br/>";
echo  Color::BLACK;
echo "<br/>";

$coloredPoint = ColoredPoint::make(1.0, 2.0, $color);
$coloredPoint->print();