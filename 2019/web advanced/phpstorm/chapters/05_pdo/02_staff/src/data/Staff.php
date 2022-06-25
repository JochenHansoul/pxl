<?php

declare(strict_types=1);

namespace data;

class Staff
{
    public readonly int $id;
    public readonly string $email;
    public readonly string $nameFirst;
    public readonly string $nameLast;

    public function __construct(
        int $id,
        string $email,
        string $nameFirst,
        string $nameLast
    ) {
        $this->id = $id;
        $this->email = $email;
        $this->nameFirst = $nameFirst;
        $this->nameLast = $nameLast;
    }

    public function getFullName(): string
    {
        return $this->nameFirst . " " . $this->nameLast;
    }

    public function equals($o): bool
    {
        return (get_class($o) === get_called_class()
            || is_subclass_of($o, get_called_class()))
            && $this->id === $o->id
            && $this->email === $o->email
            && $this->nameFirst === $o->nameFirst
            && $this->nameLast === $o->nameLast;
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
