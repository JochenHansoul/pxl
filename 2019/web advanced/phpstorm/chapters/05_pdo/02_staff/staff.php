<?php

declare(strict_types=1);

use controller\StaffController;

require_once "vendor/autoload.php";

$staffController = new StaffController();
$staffMembers = $staffController->index();

// printing data
echo "<p>\n";
foreach ($staffMembers as $staff) {
    echo $staff->getName() . "<br/>\n";
}
echo "</p>\n";
