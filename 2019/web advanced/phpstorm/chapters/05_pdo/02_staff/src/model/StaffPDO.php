<?php

declare(strict_types=1);

namespace model;

use function utils\getStudentPDO;

require_once __DIR__ . "/../../vendor/autoload.php";

class StaffPDO
{
    private \PDO $pdo;

    public function __construct()
    {
        $this->pdo = getStudentPDO();
    }

    public function getStaff(): array
    {
        $statement = $this->pdo->query("SELECT * FROM staff");
        $statement->setFetchMode(\PDO::FETCH_ASSOC);
        $staffMembers = [];
        foreach($statement->fetchAll() as $row) {
            $staffMembers[] = new Staff(intval($row["user_id"]), $row["name"]);
        }
        return $staffMembers;
    }
}
