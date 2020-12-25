<?php

namespace Triangles;

function symmetricalTriangle(string $symbol, int $amount): string
{
    $output = "";
    for ($i = 1; $i <= $amount; $i++) {
        $output .= str_repeat(' ', $amount - $i) . str_repeat($symbol, 1 + 2 * ($i - 1)) . "\n";
    }
    return $output;
}
