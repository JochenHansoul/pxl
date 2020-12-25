<?php

require_once "src/Constants/Database/DNS.php";
require_once "src/Constants/User/USERS.php";
//require "src/Constants/User/PASSWORDS.php";
// Constant PASSWORDS already defined in ...
// maar het programma wordt wel uitgevoerd

use const Constants\User\USERS;
use const Constants\Database\DNS;
use const Constants\Database\HOST;

$rootUser = USERS["root"];

echo "DNS: " . DNS . "\n\n";
echo "user: {$rootUser["name"]}\npassword: {$rootUser["password"]}\n\n";
echo "HOST: " . HOST . "\n";