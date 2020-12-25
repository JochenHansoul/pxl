<?php

namespace Workers;

use Tools\Usable;

class Handyman implements Workable
{
    private Usable $tool;

    public function __construct(Usable $tool)
    {
        $this->tool = $tool;
    }

    public function work(): void
    {
        $this->tool->useTool();
    }
}