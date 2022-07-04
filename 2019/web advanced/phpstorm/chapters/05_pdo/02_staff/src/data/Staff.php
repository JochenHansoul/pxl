<?php

declare(strict_types=1);

namespace data;

class Staff
{
    use ComparableWithSameOrChildClass;

    public readonly int $id;
    public readonly string $email;
    public readonly string $nameFirst;
    public readonly string $nameLast;
    public readonly ?\DateTime $dateBirth;

    public function __construct(
        int $id,
        string $email,
        string $nameFirst,
        string $nameLast,
        ?\DateTime $dateBirth = null
    ) {
        $this->id = $id;
        $this->email = $email;
        $this->nameFirst = $nameFirst;
        $this->nameLast = $nameLast;
        $this->dateBirth = $dateBirth;
    }

    public function getFullName(): string
    {
        return $this->nameFirst . " " . $this->nameLast;
    }

    public function equals($o): bool
    {
        return $this === $o
            || ($this->isSameOrChildClass($o)
            && $this->id === $o->id
            && $this->email === $o->email
            && $this->nameFirst === $o->nameFirst
            && $this->nameLast === $o->nameLast);
    }

    public function copy(
        $id = null,
        $email = null,
        $nameFirst = null,
        $nameLast = null
    ): self {
        return new self(
            $id ?? $this->id,
            $email ?? $this->email,
            $nameFirst ?? $this->nameFirst,
            $nameLast ?? $this->nameLast);
    }

    public function __toString(): string
    {
        return "staff{ id = " . $this->id
            . ", email = " . $this->email
            . ", nameFirst = " . $this->nameFirst
            . ", nameLast = " . $this->nameLast
            . "}";
    }
}
