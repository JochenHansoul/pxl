<?php

declare(strict_types=1);

function voidFunction(): void
{
    //does nothing
}

// checking return type
echo gettype(voidFunction()) . "\n"; // NULL
echo gettype(null) . "\n";
echo null . "\n";
echo "end ", "of ", "line.";
