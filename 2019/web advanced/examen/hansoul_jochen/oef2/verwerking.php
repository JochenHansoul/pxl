<?php
// naam: Jochen Hansoul
use model\ModelException;
use model\ProductModel;

require_once 'vendor/autoload.php';

$host = '127.0.0.1'; //aangepast
$db = 'examenwa2020';
$user = 'root';
$password = ''; //aangepast
$charset = 'utf8mb4';
$dsn = "mysql:host=$host;dbname=$db;charset=$charset";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
];

try {
    $pdo = new PDO($dsn, $user, $password, $options);
    $productModel=new ProductModel($pdo);
    // ...
    $id = $_GET["product_id"]; //dit heb ik achteraf verbeterd
    //$productModel->deleteProduct($id); // volgende twee lijnen toegevoegd
    $numberOfRows = $pdo->exec("DELETE FROM product WHERE id = $id");
    echo "removed $numberOfRows";
} catch (ModelException $exception){
    print("oops");
}
$pdo = null;
?>

