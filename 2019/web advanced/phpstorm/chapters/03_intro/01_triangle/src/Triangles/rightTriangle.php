<?php

namespace Triangles;

function rightTriangle(string $symbol, int $amount): string
{
    $output = "";
    for ($i = 1; $i <= $amount; $i++) {
        $output .= str_repeat(' ', $amount - $i) . str_repeat($symbol, $i) . "\n";
    }
    return $output;
}
