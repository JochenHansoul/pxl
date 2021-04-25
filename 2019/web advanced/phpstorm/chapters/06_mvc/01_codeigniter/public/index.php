<?php

use Config\Paths;

const MIN_VERSION = 7.2;
const PATH_CONFIG = "/app/Config/Paths.php"; // change path depending on dir structure

$phpVersion = phpversion();

if ($phpVersion >= MIN_VERSION) {
    require_once dirname(__DIR__) . PATH_CONFIG;
    // Ensure the current directory is pointing to the front controller's directory
    chdir(__DIR__);
    // $paths object needs to be created, can not only be required
    $paths = new Paths();
    $app = require_once $paths->systemDirectory . "/bootstrap.php"; // bootstrap file
    $app->run(); // launch application
} else {
    echo "Your PHP version must be " . MIN_VERSION
        . " or higher to run CodeIgniter. Current version: {$phpVersion}";
}
