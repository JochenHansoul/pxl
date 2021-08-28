<?php

class UserPDO
{
    private $pdo;

    public function __construct($dsn, $user, $passwd, $options)
    {
        $this->pdo = new PDO($dsn, $user, $passwd, $options);
    }

    public function getUsers()
    {
        $statement = $this->pdo->query('SELECT * FROM user');
        $statement->setFetchMode(PDO::FETCH_ASSOC);
        return $statement->fetchAll();
    }
}


