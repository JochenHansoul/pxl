<?php

declare(strict_types=1);

$var1 = "hello";
$$var1 = "world";

echo "var1 and \$var1: $var1 ${$var1}\n";
echo "hello: $hello\n";
