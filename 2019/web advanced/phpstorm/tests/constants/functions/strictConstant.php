<?php

declare(strict_types=1);

require_once "src/strictFunction";

//const C = strictFunction(); // PHP Fatal error:  Constant expression contains invalid operations
const D = sprintf("this string constainst the value %s", "VALUE"); // just the same error
