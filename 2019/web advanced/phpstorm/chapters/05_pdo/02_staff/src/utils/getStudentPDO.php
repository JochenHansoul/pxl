<?php

declare(strict_types=1);

namespace utils;

function getStudentPDO(): \PDO
{
    // dsn
    $dns = "mysql:host=localhost;dbname=oefpdo;charset=utf8mb4";

    // pdo
    $user = "student";
    $password = "pxl";
    $options = [
	    \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION,
	    \PDO::ATTR_DEFAULT_FETCH_MODE => \PDO::FETCH_ASSOC
    ];
    return new \PDO($dns, $user, $password, $options);
}
