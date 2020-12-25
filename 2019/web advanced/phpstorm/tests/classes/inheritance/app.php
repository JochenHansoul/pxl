<?php

require_once "src/BaseClass.php";
require_once "src/SubBaseClass.php";
require_once "src/SubAbstractClass.php";

$o = new BaseClass();
echo "\n";
$so = new SubBaseClass();
echo "\n";
$sac = new SubAbstractClass();
