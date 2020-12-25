<?php

namespace Database;

require_once "OPTIONS.php";

class PDOClass
{
	private PDO $pdo;

	public function __construct(
		string $dsn,
		string $name,
		string $password,
		array $options = OPTIONS
	) {
		$this->pdo = new PDO($dsn, $name, $password, $options);
	}

	public function getAllRows(string $table): array
	{
		$statement = $this->pdo->query("SELECT * FROM $table");
		$statement->setFetchMode(PDO::FETCH_ASSOC);
		return $statement->fetchAll();
	}
}
