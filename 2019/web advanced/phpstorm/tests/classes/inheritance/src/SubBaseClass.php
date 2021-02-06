<?php

declare(strict_types=1);

require_once "BaseClass.php";

class SubBaseClass extends BaseClass
{
    public function __construct()
    {
        parent::__construct();
        echo "constructor: Sub Base Class" . "\n"; // withouth constructor the constructor of the BaseClass is user
    }
}
