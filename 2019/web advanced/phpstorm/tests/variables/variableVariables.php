<?php

declare(strict_types=1);

// creating variable variables
$var1 = "hello";
$$var1 = "world";

// printing
echo "var1 and \$var1: $var1 ${$var1}\n";
echo "hello: $hello\n";







// even more stupid
echo "\neven more stupid:\n";
$specialVar = "stupid variable name";
${$specialVar} = "wtf";
//${can i do this} = "is this possible?"; // nope
//${stupid1} = "is stupid";

echo "stupid variable name: ${$specialVar}\n";
//echo "stupid variable name: ${$tupid variable name}\n"; // syntax error
//echo "stupid1: $stupid1\n";
