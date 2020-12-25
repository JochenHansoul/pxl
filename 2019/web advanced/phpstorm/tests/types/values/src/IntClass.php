<?php

class IntClass
{
    private int $i;
    
    public function __construct(int $i)
    {
        echo "i is value $i and type " . gettype($i);
        $this->i = $i;
    }

    public function getValue(): int
    {
        return $this->i;
    }
}

