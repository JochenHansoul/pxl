<?php

declare(strict_types=1);

function fizzbuzz(int $n): string
{
    return ($n % 3 === 0) ? ($n % 5 === 0) ? "fizzbuzz" : "fizz"
        : (($n % 5 === 0) ? "buzz" : "" . $n);
}

for ($i = 1; $i <= 20; $i++) {
    echo fizzbuzz($i) . "\n";
}
