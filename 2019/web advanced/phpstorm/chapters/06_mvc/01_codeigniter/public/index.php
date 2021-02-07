<?php

use Config\Paths;

const MIN_PHP_VERSION = 7.2;
const PATH_CONFIGURATION_FILE = "/app/Config/Paths.php";
// This is the line that might need to be changed, depending on your folder structure.

if (phpversion() >= MIN_PHP_VERSION) {
    // bootstrap and launch application
    require_once dirname(__DIR__) . PATH_CONFIGURATION_FILE; 
    chdir(__DIR__); // Ensure the current directory is pointing to the front controller's directory
    $paths = new Paths(); // this object is neccessary for some unknown reason
    //$app = require_once (new Paths())->systemDirectory . "/bootstrap.php";
    $app = require_once "../vendor/codeigniter4/framework/system/bootstrap.php";
    unset($paths); // but can be safely removed after the require_once statement
    $app->run(); // launch application
} else {
    echo "Your PHP version must be " . MIN_PHP_VERSION . " or higher to run CodeIgniter. Current version: " . phpversion();
}
