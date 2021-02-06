<?php

declare(strict_types=1);

require_once "AbstractClass.php";

class SubAbstractClass extends AbstractClass
{
    public function __construct()
    {
        echo "constructor: Sub Abstract Class" . "\n";
    }
}
