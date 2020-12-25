<?php 
// naam: Jochen Hansoul
namespace model;

use PDO;

class ProductModel
{
    private PDO $pdo;

    public function __construct(PDO $pdo)
    {
        $this->pdo = $pdo;
    }

    public function getAllProducts()
    {
        try {
            $query = "SELECT * from products";
            $statement = $this->pdo->query($query);
            $statement->setFetchMode(PDO::FETCH_ASSOC);
            return $statement->fetchAll();
        } catch (\PDOException $e) {
            throw new ModelException($e);
        }
    }

    public function deleteProduct(int $id)
    {
        try {
            $statement = $this->pdo->prepare('DELETE * FROM products WHERE id = :id');
            $statement->bindParam(':id', $id, PDO::PARAM_INT);
            $statement->setFetchMode(PDO::FETCH_ASSOC);
            $statement->execute();
        } catch (\PDOException $e) {
            throw new ModelException($e);
        }
    }
}