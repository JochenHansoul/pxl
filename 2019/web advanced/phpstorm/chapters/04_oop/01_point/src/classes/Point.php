<?php

namespace classes;

class Point
{
    public const MAXIMUM_XY = 100;
    public const MINIMUM_XY = 0;
    protected float $x;
    protected float $y;

    public function __construct(float $x, float $y)
    {
        $this->x = $this->checkInput($x);
        $this->y = $this->checkInput($y);
    }

//    public function __set($name, $value)
//    {
//        $this->$name = $value;
//    }
//
//    public function __get($name)
//    {
//        return $this->$name;
//    }

    public function setX(float $x): void
    {
        $this->x = $this->checkInput($x);
    }

    public function setY(float $y): void
    {
        $this->y = $this->checkInput($y);
    }

    public function getX(): float
    {
        return $this->x;
    }

    public function getY(): float
    {
        return $this->y;
    }

    public function __toString(): string
    {
        return "($this->x , $this->y)";
    }

    public function calculateDistance(Point $point)
    {
        return sqrt( ($this->x - $point->x) * ($this->x - $point->x)
            + ($this->y - $point->y) * ($this->y - $point->y));
    }

    private function checkInput($input): float
    {
        if ($input < self::MINIMUM_XY) {
            $input = self::MINIMUM_XY;
        }
        elseif ($input > self::MAXIMUM_XY) {
            $input = self::MAXIMUM_XY;
        }
        return $input;
    }
}