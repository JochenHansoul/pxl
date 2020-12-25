<?php namespace map;

use \drawing\Line;

class Road{
    private Line $line;
    private string $name;

    public function __construct(string $name, Line $line)
    {
        $this->name = $name;
        $this->line = $line;
    }

    public function __toString(): string
    {
        return "{$this->name}: {$this->line->__toString()}";
    }
}
