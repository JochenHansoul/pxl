<?php

//declare(strict_types=1);

require_once "./src/someFunction.php";

someFunction(1);
someFunction("1");
someFunction(1.1);
someFunction("1.1");

// nonsense
echo "\nnonsense:\n";
someFunction(""); // type error, stops execution
someFunction("hello, world");
