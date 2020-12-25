<?php

namespace classes;

class Color
{
    const BLACK = 0x000000; // constanten geen $ voor, zijn publiek en kunnen via de klassenaam gebruikt worden
    const WHITE = 0xFFFFFF;
    const RED = 0xFF0000;
    const GREEN = 0xFF00FF;
    const BLUE = 0x0000FF;
    const YELLOW = 0xFFFF00;
    private int $rgb;

    private function __construct(int $rgb)
    {
        $this->rgb = $rgb;
    }

    public static function makeColor(int $rgb): Color
    {
        return new self($rgb);
    }

    public function getRgb(): int
    {
        return $this->rgb;
    }

    public function toString(): string
    {
        return dechex($this->rgb);
    }
}