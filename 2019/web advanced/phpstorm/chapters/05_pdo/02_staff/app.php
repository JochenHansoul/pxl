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
      $staffMembers = $staffPDO->getStaff();
?>
  <ul>
<?php foreach ($staffMembers as $staff): ?>
    <li><?php echo $staff->getFullName(); ?></li>
<?php endforeach;
  } catch (\PDOException $e) {
      echo $e->getMessage();
  }
?>
  </ul>
</body>
</html>
