<?php

namespace Constants\User;

require_once "PASSWORDS.php";
require_once "OPTIONS.php";

use const Constants\User\PASSWORDS;
use const Constants\User\OPTIONS;

const USERS = [
    "root" => [
        "name" => "root",
        "password" => PASSWORDS["root"],
        "options" => OPTIONS,
        "enabled" => true
    ],
    "jochen" => [
        "name" => "jochen",
        "password" => PASSWORDS["jochen"],
        "options" => OPTIONS,
        "enabled" => true
    ]
];