<?php

require_once "./src/StaffPDO.php";

// dsn
const SERVER = 'localhost';
const DATABASE = 'oefpdo';
const CHARSET = "utf8mb4";
const DSN = "mysql:host=" . SERVER . ";dbname=" . DATABASE . ";charset=" . CHARSET;

// pdo
const USER = 'student';
const PASSWORD = 'pxl';
const OPTIONS = [
	PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
];

// retrieving data
$rows = [];
try {
    $staffPdo = new StaffPDO(DSN, USER, PASSWORD, OPTIONS);
    $rows = $staffPdo->getStaff();
} catch (PDOException $e) {
    echo "PDOEexception: " . $e->getMessage();
}

// printing data
echo "<p>\n";
foreach ($rows as $row) {
    echo $row["user_id"] . " " . $row["name"] . "<br/>\n";
}
echo "</p>\n";
