<?php

const SERVER = 'localhost'; // ik moet hier waarschijnlijk mijn poortnummer nog achter zetten
const DATABASE = 'oefpdo';
const USER = 'student';
const PASSWORD = 'pxl';

$pdo = null;
try {
    $pdo = new PDO("mysql:host=" . SERVER . ";dbname=" . DATABASE, USER, PASSWORD);
    echo "you have connected\n";
    $pdo->setAttribute(
        PDO::ATTR_ERRMODE,
        PDO::ERRMODE_EXCEPTION
    );
    $statement = $pdo->query('SELECT * FROM werknemers');
    $statement->setFetchMode(PDO::FETCH_ASSOC);
    while ($row = $statement->fetch()) {
        print_r($row);
    }
} catch (PDOException $e) {
    echo "ERROR: " . $e->getMessage();
}
$pdo = null;
