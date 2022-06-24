<?php

declare(strict_types=1);

namespace pdo;

use data\Staff;

use function utils\getStudentPDO;


class StaffPDO
{
    // table
    private const STAFF_TABLE = "staff";

    // rows
    private const STAFF_ID = "id_staff";
    private const STAFF_NAME_FIRST = "name_first";
    private const STAFF_NAME_LAST = "name_last";

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
            $staffMembers[] = new Staff(
                intval($row[self::STAFF_ID]),
                $row[self::STAFF_NAME_FIRST],
                $row[self::STAFF_NAME_LAST]
            );
        }
        return $staffMembers;
    }
}
