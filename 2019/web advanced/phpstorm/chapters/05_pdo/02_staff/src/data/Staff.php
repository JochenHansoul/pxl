<?php

declare(strict_types=1);

namespace data;

class Staff
{
    public readonly int $id;
    public readonly string $nameFirst;
    public readonly string $nameLast;

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
