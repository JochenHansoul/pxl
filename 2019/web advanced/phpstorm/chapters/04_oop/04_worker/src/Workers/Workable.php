<?php

namespace Workers;

interface Workable
{
    public function work(): void;
}