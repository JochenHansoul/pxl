<?php

/**
 * Holds the paths that are used by the system to
 * locate the main directories, app, system, etc.
 *
 * All paths are relative to the project's root folder.
 */

namespace Config;

const DIRECTORY_PATHS = [
	"system" => __DIR__ . "/../../vendor/codeigniter4/framework/system";
	"app" => __DIR__ . "/..";
	"writable" => __DIR__ . "/../../writable";
	"tests" => __DIR__ . "/../../tests";
	"view" => __DIR__ . "/../Views";
];
