<?php

class Foo
{
    public function __construct()
    {
        echo "Foo created";
    }

    function __toString(): string
    {
        return "hello world";
    }
}
