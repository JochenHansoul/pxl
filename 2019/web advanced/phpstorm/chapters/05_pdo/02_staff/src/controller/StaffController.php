<?php

namespace controller;

use pdo\StaffPDO;

class StaffController
{
    // dsn
    const SERVER = 'localhost';
    const DATABASE = 'oefpdo';
    const CHARSET = "utf8mb4";
    const DSN = "mysql:host=" . self::SERVER . ";dbname=" . self::DATABASE . ";charset=" . self::CHARSET;

    // pdo
    const USER = 'student';
    const PASSWORD = 'pxl';
    const OPTIONS = [
	    \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION,
	    \PDO::ATTR_DEFAULT_FETCH_MODE => \PDO::FETCH_ASSOC
    ];

    public function __construct()
    {
    }

    public function index()
    {
        // retrieving data
        //echo "\n";
        //echo var_export(OPTIONS);
        //echo "\n";
        $rows = [];
        try {
            $staffPdo = new StaffPDO(self::DSN, self::USER, self::PASSWORD, self::OPTIONS);
            $rows = $staffPdo->getStaff();
        } catch (\PDOException $e) {
            echo "PDOEexception: " . $e->getMessage();
        }
        return $rows;
    }
}
