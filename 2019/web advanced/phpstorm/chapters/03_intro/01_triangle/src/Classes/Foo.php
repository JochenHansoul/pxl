<?php

namespace Classes;

class Foo
{
    private string $var;

    public function __construct(string $var)
    {
        $this->var = $var;
    }

    public function toString(): string
    {
        return $this->var;
    }

    public function returnTrue(): bool
    {
        return true;
    }
}