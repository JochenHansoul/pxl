<?php

declare(strict_types=1);

use controller\StaffController;

require_once "vendor/autoload.php";

$staffController = new StaffController();
$rows = $staffController->index();

// printing data
echo "<p>\n";
foreach ($rows as $row) {
    echo $row["user_id"] . " " . $row["name"] . "<br/>\n";
}
echo "</p>\n";
