<?php

declare(strict_types=1);

use pdo\StaffPDO;

require_once "vendor/autoload.php";

?>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>staff members</title>
</head>
<body>
  <h1>staff members</h1>
<?php
  try {
      $staffPDO = new StaffPDO();
      $staffMembers = $staffPDO->getAllStaff(); ?>
  <ul>
<?php foreach ($staffMembers as $staff): ?>
    <li><?php echo $staff->getFullName(); ?></li>
<?php endforeach; ?>
  </ul>
<?php } catch (\PDOException $e) { ?>
  <p><?php echo $e->getMessage();?></p>
<?php } ?>
</body>
</html>
