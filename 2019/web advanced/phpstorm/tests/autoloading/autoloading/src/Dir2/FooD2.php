<?php

class FooD2
{
    public function __construct()
    {
        echo "Foo D2 created";
    }

    function __toString(): string
    {
        return "hello world";
    }
}
