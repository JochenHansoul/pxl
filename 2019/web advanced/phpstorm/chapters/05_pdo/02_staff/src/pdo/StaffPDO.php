<?php

declare(strict_types=1);

namespace pdo;

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
        return $statement->fetchAll();
    }
}


