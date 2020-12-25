<?php

require_once "AbstractClass.php";

class SubAbstractClass extends AbstractClass
{
    public function __construct()
    {
        echo "Sub Abstract Class";
    }
}
