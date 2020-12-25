<?php

use Database\PDODatabases;

use const Database\DSN;
use const Database\OPTIONS;
use const User\USERS;

require_once "vendor/autoload.php";

const USER = USERS["student"];

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
    $pdo = new PDODatabases(DSN, USER["name"], USER["password"]);
    $databaseNames = $pdo->getDatabases();
    if (count($databaseNames) > 0) {
        ?>
        <form action="verwerking.php" method="get">
            <label for="database">Databases<label>
            <br>
            <select name="database">
                <?php
	            $optionString = "</option>\n" . str_pad("<option>", 24, " ", STR_PAD_LEFT);
	            echo "<option>" . implode($optionString, $databaseNames) . "</option>\n";
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
    } else {
	?><p>No databases found</p><?php
    }
} catch (PDOException $e) {
    echo "ERROR: " . $e->getMessage();
}
$pdo = null;
?>
</body>
</html>
