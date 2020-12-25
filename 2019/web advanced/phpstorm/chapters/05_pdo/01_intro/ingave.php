<?php

require_once("server-settings.php");

const DATABASE = "";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ingave</title>
    <!--<link rel="stylesheet" href="css/ingave.css">-->
</head>
<body>
<?php
$pdo = null;
try {
    $pdo = new PDO("mysql:host=" . SERVER . ";dbname=" . DATABASE, USER, PASSWORD);
    echo "<h1>you have connected</h1>";
    $pdo->setAttribute(
        PDO::ATTR_ERRMODE,
        PDO::ERRMODE_EXCEPTION
    );
    $statement = $pdo->query('SHOW DATABASES');
    $statement->setFetchMode(PDO::FETCH_ASSOC);
    //$databases = $statement->fetchAll();
    if ($statement->rowCount() > 0) {
        $columnNames = []; // komen al de namen van de kolommen (in dit geval gewoon Database) in terecht
        for ($i = 0; $i < $statement->columnCount(); $i++) {
            $columnData = $statement->getColumnMeta($i); // gets all metadata abouth the column
            $columnNames[] = $columnData["name"]; // gets the name of the column and ads it after the next free open place in the array
        }
        ?>
        <form action="verwerking.php" method="get">
            <label for="database"><?php echo $columnNames[0] ?></label>
            <br>
            <select name="database">
                <?php
                while ($row = $statement->fetch()) {
                    echo '<option>' . implode('</option><option', $row) . '</option>';
                }
                ?>
            </select>
            <br>
            <label for="query">query</label>
            <br>
            <input type="text" id="query" name="query"/>
            <br>
            <input type="submit">
        </form>
        <?php
    }
} catch (PDOException $e) {
    echo "ERROR: " . $e->getMessage();
}
$pdo = null;
?>
</body>
</html>
