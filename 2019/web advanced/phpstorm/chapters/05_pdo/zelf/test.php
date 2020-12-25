<?php

use Database\PDODatabases;
use Database\PDOClass;

use const Database\DSN;
use const Database\OPTIONS;
use const User\USERS;

require_once "vendor/autoload.php";

$student = USERS["student"];

$pdo = new PDODatabases(DSN, $student["name"], $student["password"], OPTIONS);
$data = $pdo->getDatabases();
var_export($data);
//print_r(array_values($data));

/*foreach($data as $database) {
	echo $database["Database"] . "\n";
}*/

$dsn = $dsn = "mysql:host=127.0.0.1;dbname=oefpdo;charset=utf8mb4";
$pdo = new PDOClass($dsn, $student["name"], $student["password"]);
