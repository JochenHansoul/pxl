<?php

function testFunction(): void
{
    //does nothing
}

echo gettype(testFunction()) ."\n"; // NULL
echo gettype(null) . "\n";
