<?php

namespace pdo;

class StaffPDO
{
    private $pdo;

    public function __construct($dsn, $user, $passwd, $options)
    {
        $this->pdo = new \PDO($dsn, $user, $passwd, $options);
    }

    public function getStaff()
    {
        $statement = $this->pdo->query("SELECT * FROM staff");
        $statement->setFetchMode(\PDO::FETCH_ASSOC);
        return $statement->fetchAll();
    }
}


