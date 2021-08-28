<?php

require_once "./src/StaffPDO.php";

class StaffController
{
    // dsn
    private const SERVER = 'localhost';
    private const DATABASE = 'oefpdo';
    private const CHARSET = "utf8mb4";
    private const DSN = "mysql:host=" . SERVER . ";dbname=" . DATABASE . ";charset=" . CHARSET;

    // pdo
    private const USER = 'student';
    private const PASSWORD = 'pxl';
    private const OPTIONS = [
	    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
    ];

    public function index()
    {
        // retrieving data
        $rows = [];
        try {
            $staffPdo = new StaffPDO(DSN, USER, PASSWORD, OPTIONS);
            $rows = $staffPdo->getStaff();
        } catch (PDOException $e) {
            echo "PDOEexception: " . $e->getMessage();
        }
        return $rows;
    }
}
