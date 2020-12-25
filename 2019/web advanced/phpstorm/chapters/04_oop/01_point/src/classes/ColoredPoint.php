<?php
//require_once 'Color.php';

namespace classes;

class ColoredPoint extends Point
{
    private Color $color;

    private function __construct(float $x, float $y, Color $color)
    {
        parent::__construct($x, $y);
        $this->color = $color;
    }

    public static function make($x, $y, $color): ColoredPoint
    {
        return new self($x, $y, $color);
    }

    public function print(): void
    {
        echo "({$this->x}, {$this->y}) colour: {$this->color->toString()}";
    }
}