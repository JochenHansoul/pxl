<?php

require_once "BaseClass.php";

class SubBaseClass extends BaseClass
{
    public function __construct()
    {
        parent::__construct();
        echo "Sub Base Class"; // withouth constructor the constructor of the BaseClass is user
    }
}
