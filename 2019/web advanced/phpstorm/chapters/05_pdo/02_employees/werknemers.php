<?php

const SERVER = 'localhost'; // ik moet hier waarschijnlijk mijn poortnummer nog achter zetten
const DATABASE = 'oefpdo';
const USER = 'student';
const PASSWORD = 'pxl';

$rows = null;

$pdo = null;
try {
    $pdo = new PDO("mysql:host=" . SERVER . ";dbname=" . DATABASE, USER, PASSWORD);
    $pdo->setAttribute(
        PDO::ATTR_ERRMODE,
        PDO::ERRMODE_EXCEPTION
    );
    $statement = $pdo->query('SELECT * FROM user');
    $statement->setFetchMode(PDO::FETCH_ASSOC);
    $rows = $statement->fetchAll();
} catch (PDOException $e) {
    echo "PDOEexception: " . $e->getMessage();
}
$pdo = null;

echo "<p>";
while ($row = $rows) {
    echo $row["user_id"] . " " . $row["name"] . "<br/>";
}
echo "</p>";
