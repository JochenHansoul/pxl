<?php

declare(strict_types=1);

use controller\StaffController;

require_once "vendor/autoload.php";

$staffController = new StaffController();
$staffMembers = $staffController->index();

// printing data

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>staff members</title>
</head>
<body>
    <ol>
    <?php foreach ($staffMembers as $staff): ?>
        <li><?php echo $staff->getName(); ?></li>
    <?php endforeach ?>
    </ol>
</body>
</html>
