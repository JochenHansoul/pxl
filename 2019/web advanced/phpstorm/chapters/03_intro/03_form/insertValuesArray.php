<?php

declare(strict_types=1);

$url = "insertLengthArray.html";
$arrayLength = (ctype_digit($_GET["arrayLength"])) ? (int) $_GET["arrayLength"] : 0;
if ($arrayLength > 0) {
    ?>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>insertValuesArray</title>
    </head>
    <body>
        <form action="outputArray.php">
        <?php
            for($i = 0; $i < $arrayLength; $i++) {
            ?>
            <input type="text" name="numbers[]"/>
            <br/>
            <?php
            }
        ?>
        <input type="submit"/>
        </form>
    </body>
    </html>
    <?php
} else {
    header("Location: $url");
}
