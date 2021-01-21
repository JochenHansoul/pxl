<?php

echo getcwd() . "\n";
chdir("images");
echo getcwd() . "\n";
// chdir("unexisting"); // PHP Warning:  chdir(): No such file or directory (errno 2)
chdir(".." . DIRECTORY_SEPARATOR . "..");
echo getcwd() . "\n";
