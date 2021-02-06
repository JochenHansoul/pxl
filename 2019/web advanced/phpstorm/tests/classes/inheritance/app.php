<?php

// tests for testing wich constructor is ues

declare(strict_types=1);

require_once "src/BaseClass.php";
require_once "src/SubBaseClass.php";
require_once "src/SubAbstractClass.php";

echo "BaseClass:" . "\n";
new BaseClass();
echo "\n";

echo "SubBaseClass:" . "\n";
new SubBaseClass();
echo "\n";

echo "SubAbstractClass:" . "\n";
new SubAbstractClass();
echo "\n";
