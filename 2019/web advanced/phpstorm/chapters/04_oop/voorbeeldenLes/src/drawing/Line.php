<?php

namespace drawing;

class Line
{
    private Point $startPoint;
    private Point $endPoint;

    public function __construct(Point $startPoint, Point $endPoint)
    {
        $this->startPoint = $startPoint;
        $this->endPoint = $endPoint;
    }

    public function __toString(): string
    {
        return "{$this->startPoint} - {$this->endPoint}";
    }
}