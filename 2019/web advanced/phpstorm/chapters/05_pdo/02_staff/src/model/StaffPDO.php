<?php

declare(strict_types=1);

namespace model;

use function utils\getStudentPDO;

require_once __DIR__ . "/../../vendor/autoload.php";

class StaffPDO
{
    // table
    const STAFF_TABLE = "staff";

    // rows
    const STAFF_ID = "user_id";
    const STAFF_NAME = "name";

    // PDO
    private \PDO $pdo;

    public function __construct()
    {
        $this->pdo = getStudentPDO();
    }

    public function getStaff(): array
    {
        $statement = $this->pdo->query("SELECT * FROM " . self::STAFF_TABLE);
        $statement->setFetchMode(\PDO::FETCH_ASSOC);
        $staffMembers = [];
        foreach($statement->fetchAll() as $row) {
            $staffMembers[] = new Staff(intval($row[self::STAFF_ID]), $row[self::STAFF_NAME]);
        }
        return $staffMembers;
    }
}
