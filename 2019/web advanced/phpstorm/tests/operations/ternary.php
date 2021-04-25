<?php

declare(strict_types=1);

const BOOL1 = true;
const BOOL2 = true;

const V = BOOL1 ? "T1"
    : (BOOL2 ? "T2"
    : "false");
echo V;
