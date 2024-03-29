<?php

declare(strict_types=1);

namespace utils;

function getStudentPDO (): \PDO {
    $dns = "mysql:host=localhost;dbname=oef_pdo;charset=utf8mb4";
    $user = "oef_pdo_user";
    $password = "password";
    $options = [
	    \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION,
	    \PDO::ATTR_DEFAULT_FETCH_MODE => \PDO::FETCH_ASSOC
    ];
    return new \PDO($dns, $user, $password, $options);
}
