<?php

namespace Triangles;

function intervalTriangle(string $symbol, string $secondSymbol, int $amount, int $interval = 2): string
{
    $output = "";
    $intervalCounter = $interval;
    for ($i = 1; $i <= $amount; $i++) {
        $output .= str_repeat(' ', $amount - $i);
        for ($j = 0; $j < 1 + 2 * ($i - 1); $j++) {
            if ($intervalCounter === $interval) {
                $output .= $secondSymbol;
                $intervalCounter = 1;
            } else {
                $output .= $symbol;
                $intervalCounter++;
            }
            /*$intervalCounter === $interval
                ? ($output .= $secondSymbol) && $intervalCounter = 1
                : ($output .= $symbol) && $intervalCounter++;*/
        }
        $output .= "\n";
    }
    return $output;
}
