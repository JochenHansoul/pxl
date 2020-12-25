<?php

require_once "Dir1/FooD1.php";
//require_once "Dir2/FooD2.php";
require_once "Dir2/autoload.php";

if (!function_exists("classAutoLoader")) {
    function classAutoLoader($className)
    {
        $file = "src/" . str_replace("\\", "/", $className) . ".php";
        if (file_exists($file)) {
            require_once $file;
        }
    }
}
spl_autoload_register("classAutoLoader");
