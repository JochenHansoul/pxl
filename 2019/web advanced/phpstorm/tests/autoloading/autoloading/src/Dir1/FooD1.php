<?php

class FooD1
{
    public function __construct()
    {
        echo "Foo D1 created";
    }

    function __toString(): string
    {
        return "hello world";
    }
}
