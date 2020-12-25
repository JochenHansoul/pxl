<?php
// naam: Jochen Hansoul
use model\ModelException;
use model\ProductModel;

require_once 'vendor/autoload.php';

//$host = '192.168.33.22';
$host = '127.0.0.1';
$db   = 'examenwa2020';
$user = 'root';
//$password = 'root';
$password = '';
$charset = 'utf8mb4';
$dsn = "mysql:host={$host};dbname={$db};charset={$charset}";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
];

try {
    $pdo = new PDO($dsn, $user, $password, $options);
    $productModel = new ProductModel($pdo);
    // ...
    //$results = $productModel->getAllProducts(); // dit was fout
    $results = $pdo->query("SELECT * FROM product");
    ?>
    <form action="verwerking.php" method="get">
        <select name="product_id"><!--Dit is de key voor de waarde op te halen-->
            <?php
            foreach ($results as $row) {
                ?>
                <option name="id" value="<?php echo $row["id"]?>">
                    <?php echo "{$row["name"]} ({$row["weight"]})"?>
                </option>
                <?php
            }
            ?>
        </select>
        <input type="submit" value="VERWIJDER">
    </form>
    <?php
} catch (ModelException $exception){
    print($exception->getMessage());
}
$pdo = null;
?>

