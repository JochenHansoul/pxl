<?php

declare(strict_types=1);

use controller\StaffController;

require_once "vendor/autoload.php";

$staffController = new StaffController();
$staffMembers = $staffController->index();

?>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>staff members</title>
</head>
<body>
  <h1>staff members</h1>
  <ul>
<?php foreach ($staffMembers as $staff): ?>
    <li><?php echo $staff->getName(); ?></li>
<?php endforeach ?>
  </ul>
</body>
</html>
