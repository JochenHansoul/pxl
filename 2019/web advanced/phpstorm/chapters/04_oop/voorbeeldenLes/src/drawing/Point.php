<?php

namespace drawing;

class Point
{
    public const MIN = 0;
    public const MAX = 100;
    private static int $count = 0;
    private int $x;
    private int $y;

    public function __construct(int $x,int $y)
    {
        $this->validateXY($x);
        $this->validateXY($y);
        $this->x = $x;
        $this->y = $y;
        self::$count++;
    }

    public function __destruct()
    {
        self::$count--;
    }

    private function validateXY(int $value): void
    {
        if ($value < self::MIN || $value >= self::MAX) {
            throw new \Exception("$value is not between $this::MIN and $this::MAX");
        }
    }

    public function getX(): int
    {
        return $this->x;
    }
    
    public function getY(): int
    {
        return $this->y;
    }

    public function setX(int $x): void
    {
        $this->validateXY($x);
        $this->x = $x;
    }

    public function setY(int $y): void
    {
        $this->validateXY($y);
        $this->y = $y;
    }

    public static function getCount(): int
    {
        return self::$count;
    }
    
    public static function makeOrigin(): Point
    {
        return new self(0,0);
    }

    public function __toString(): string
    {
        return "($this->x, $this->y)";
    }
}