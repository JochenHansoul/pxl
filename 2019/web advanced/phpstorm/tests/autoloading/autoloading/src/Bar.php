<?php

class Bar
{
    public function __construct()
    {
        echo "Bar created";
    }

    function __toString(): string
    {
        return "hello world";
    }
}
