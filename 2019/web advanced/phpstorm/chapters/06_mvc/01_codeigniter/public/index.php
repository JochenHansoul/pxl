<?php

use Config\Paths;

const MIN_PHP_VERSION = 7.2;
// The next line might need to be changed, depending on your folder structure.
const PATH_CONFIGURATION_FILE = "/app/Config/Paths.php";

$phpVersion = phpversion();

if ($phpVersion >= MIN_PHP_VERSION) {
    // bootstrap and launch application
    require_once dirname(__DIR__) . PATH_CONFIGURATION_FILE;
    // Ensure the current directory is pointing to the front controller's directory
    chdir(__DIR__);
    // $paths object needs to be created and may not be used to only require
    // the bootstrap file
    $paths = new Paths();
    $app = require_once $paths->systemDirectory . "/bootstrap.php";
    // launch application
    $app->run();
} else {
    echo "Your PHP version must be " . MIN_PHP_VERSION
        . " or higher to run CodeIgniter. Current version: {$phpVersion}";
}
