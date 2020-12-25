<?php

namespace Database;

require_once "OPTIONS.php";

class PDODatabases
{
    private \PDO $pdo;

    public function __construct(
	    string $dsn,
	    string $name,
	    string $password,
	    array $options = OPTIONS
    ) {
        $this->pdo = new \PDO($dsn, $name, $password, $options);
    }

    public function getDatabases(): array
    {
        $statement = $this->pdo->query("SHOW DATABASES");
        $statement->setFetchMode(\PDO::FETCH_ASSOC);
	// this returns a double nested array with 0=> [Database => valye],...
	$databases = [];
	while ($array = $statement->fetch()) {
		$databases[] = $array["Database"];
	}
	return $databases;
    }
}
