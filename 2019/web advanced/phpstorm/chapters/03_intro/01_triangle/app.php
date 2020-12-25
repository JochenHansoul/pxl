<?php

declare(strict_types=1);

use function Triangles\leftTriangle;
use function Triangles\rightTriangle;
use function Triangles\symmetricalTriangle;
use function Triangles\intervalTriangle;

use const Triangles\Constants\LINES;
use const Triangles\Constants\SYMBOL;

require_once "vendor/autoload.php";

echo "leftTriangle:\n" . leftTriangle(SYMBOL, LINES) . "\n";
echo "rightTriangle:\n" . rightTriangle(SYMBOL, LINES) . "\n";
echo "symmetricalTriangle:\n" . symmetricalTriangle(SYMBOL, LINES) . "\n";
echo "intervalTriangle:\n" . intervalTriangle(SYMBOL, "@", LINES);
