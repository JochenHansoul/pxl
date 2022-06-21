<?php

declare(strict_types=1);

namespace model;

class Staff
{
    private readonly int $id;
    private readonly string $nameFirst;
    private readonly string $nameLast;

    public function __construct(int $id, string $nameFirst, string $nameLast)
    {
        $this->id = $id;
        $this->nameFirst = $nameFirst;
        $this->nameLast = $nameLast;
    }

    public function getFullName(): string
    {
        return $this->nameFirst . " " . $this->nameLast;
    }

    public function __toString(): string
    {
        return "staff{ id = " . $this->id
            . ", nameFirst = " . $this->nameFirst
            . ", nameLast = " . $this->nameLast
            . "}";
    }
}
