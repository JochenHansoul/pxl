<?php

declare(strict_types=1);

require_once "BaseClass.php";

abstract class AbstractClass
{
    public function __construct()
    {
        echo "constructor: Abstract Class" . "\n";
    }
}
