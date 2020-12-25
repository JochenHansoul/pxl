<?php

// give in a min value and maximum value and optionally an interval (can be negative)
// creates an array based on these values
function makeRow(int $min, int $max, int $step = 1): array
{
    if ($step === 0) {
        throw new \http\Exception\InvalidArgumentException("Step cannot be 0");
    }
    $array = [];
    if ($step > 0) {
        for ($i = $min; $i <= $max; $i += $step) {
            $array[] = $i;
        }
    } else {
        for ($i = $min; $i >= $max; $i += $step) {
            $array[] = $i;
        }
    }
    return $array;
}