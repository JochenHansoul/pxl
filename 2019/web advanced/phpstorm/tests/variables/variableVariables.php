<?php

declare(strict_types=1);

// creating variable variables
$var1 = "hello";
$$var1 = "world";

// printing
echo "var1 and \$var1: $var1 ${$var1}\n";
echo "hello: $hello\n";


// true reason why it should not be done
$alreadyDefined = "variable is defined";
$var2 = "alreadyDefined";
$$var2 = "this variable is already defined";
echo $alreadyDefined . "\n"; // now this veriable is overrided
// how do we know if we have created a new variable or overrided an excisting variable




// even more stupid
echo "\neven more stupid:\n";
$specialVar = "stupid variable name";
${$specialVar} = "wtf";
//${can i do this} = "is this possible?"; // nope
//${stupid1} = "is stupid";

echo "stupid variable name: ${$specialVar}\n";
//echo "stupid variable name: ${$tupid variable name}\n"; // syntax error
//echo "stupid1: $stupid1\n";
