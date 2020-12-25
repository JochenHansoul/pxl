<?php

namespace Ns;

require_once "doubleNamespace.php";

use const Ns\Sns\A; // use zoekt nog steeds in de global namespace
echo A . "\n";
//echo Sns\A . "\n"; They do lift each other up

// global namespace:
echo \Ns\Sns\A . "\n";
