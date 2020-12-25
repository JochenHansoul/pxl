<?php

require_once("server-settings.php");

define("DATABASE", $_GET["database"]);
define("QUERY", $_GET["query"]);
define("FORBIDDEN_WORDS_IN_QUERY", ["drop", "delete", "truncate"]);

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>verwerking</title>
</head>
<body>
<?php
$pdo = null;
try {
    $pdo = new PDO("mysql:host=" . SERVER . ";dbname=" . DATABASE, USER, PASSWORD);
    $pdo->setAttribute(
        PDO::ATTR_ERRMODE,
        PDO::ERRMODE_EXCEPTION
    );
    // control input
    foreach(FORBIDDEN_WORDS_IN_QUERY as $word) {
        if (stristr(QUERY, $word)) {
            throw new \Exception("contains \"{$word}\""); // not case sensitive
        } 
    }
    // start of query and output
    $statement = $pdo->query(QUERY);
    $statement->setFetchMode(PDO::FETCH_ASSOC);
    if ($statement->rowCount() > 0){
        $columnNames = []; // komen al de namen van de kolommen (in dit geval gewoon Database) in terecht
        for ($i = 0; $i < $statement->columnCount(); $i++) {
            $columnData = $statement->getColumnMeta($i); // gets all metadata abouth the column
            $columnNames[] = $columnData["name"]; // gets the name of the column and ads it after the next free open place in the array
        }
        echo "<table>";
        echo "<thead>";
        echo "<tr><th>" . implode("</th><th>", $columnNames) . "</th></tr>";
        echo "</thead>";
        echo "<tbody>";
        // haalt telkens een rij op als een array
        while ($row = $statement->fetch()) {
            echo "<tr><td>" . implode("</td><td>", $row) . "</td></tr>";
        }
        echo "</tbody>";
        echo "</table>";
    }
} catch (PDOException $e) {
    echo "PDO ERROR: " . $e->getMessage();
} catch (\Exception $e) {
    echo "ERROR: " . $e->getMessage();
}
$pdo = null;
?>
</body>
</html>
