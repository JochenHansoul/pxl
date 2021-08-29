<?php

declare(strict_types=1);

namespace pdo;

use data\Staff;

class StaffPDO
{
    private \PDO $pdo;

    public function __construct(string $dsn, string $user, string $passwd, array $options)
    {
        $this->pdo = new \PDO($dsn, $user, $passwd, $options);
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
