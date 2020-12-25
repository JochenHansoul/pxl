<?php

declare(strict_types=1);

use function Triangles\leftTriangle;

require_once "vendor/autoload.php";
?>
<html>
<head>
    <title>triangles</title>
</head>
<body>
<?php
$triangle = leftTriangle("*", 5);
echo str_replace("\n", "<br/>", $triangle) . "\n";
?>
</body>
</html>
