<?php

declare(strict_types=1);

namespace model;

use function utils\getStudentPDO;


class StaffPDO
{
    // table
    private const STAFF_TABLE = "staff";

    // rows
    private const STAFF_ID = "user_id";
    private const STAFF_NAME = "name";

    // PDO
    private readonly \PDO $pdo;

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
