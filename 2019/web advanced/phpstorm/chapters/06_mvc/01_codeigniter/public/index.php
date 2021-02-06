<?php

const MIN_PHP_VERSION = 7.2;

// This is the line that might need to be changed, depending on your folder structure.
$pathConfigFile = dirname(__DIR__) . "/app/Config/Paths.php";

if (phpversion() >= MIN_PHP_VERSION) {
    // bootstrap and launch application
    require_once $pathConfigFile;
    chdir(__DIR__); // Ensure the current directory is pointing to the front controller's directory
    $paths = new Config\Paths(); // this object is neccessary for som unknown reason
    $app = require_once (new Config\Paths())->systemDirectory . "/bootstrap.php";
    unset($paths); // but can be safely removed after the require_once
    $app->run(); // launch application
} else {
    echo "Your PHP version must be " . MIN_PHP_VERSION . " or higher to run CodeIgniter. Current version: " . phpversion();
}
