<?php

namespace drawing;

class Line
{
    private array $points;

    public function __construct()
    {
        $this->points = [];
    }

    public function addPoint(Point $point): void
    {
        $this->points[] = $point;
    }

    public function __toString(): string
    {
        $s = "";
        foreach ($this->points as $point) {
            $s .= $point->__toString();
        }
        return $s;
    }
}