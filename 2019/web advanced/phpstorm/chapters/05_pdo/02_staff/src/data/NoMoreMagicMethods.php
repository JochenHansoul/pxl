<?php

declare(strict_types=1);

namespace data;

/*
Is it better to just make the methods private?
*/

trait NoMoreMagicMethods
{
    final public static function __callStatic(
        string $name,
        array $arguments
    ): mixed {
        throw new \Exception("Calling static methods with __call"
            . " is not allowed on " . get_called_class()
        );
    }

    final public function __set(string $name, mixed $value): void
    {
        throw new \Exception("Adding properties with __set"
            . " is not allowed on " . get_class($this)
        );
    }

    final public function __get(string $name): mixed
    {
        throw new \Exception("Getting properties with __get"
            . " is not allowed on " . get_class($this)
        );
    }

    final public function __isset(string $name): bool
    {
        throw new \Exception("Checking if properties is set with __isset"
            . " is not allowed on " . get_class($this)
        );
    }

    final public function __unset(string $name): void
    {
        throw new \Exception("Unsetting properties with __unset"
            . " is not allowed on " . get_class($this)
        );
    }

    final public function __call(string $name, array $arguments): mixed
    {
        throw new \Exception("Calling methods with __call"
            . " is not allowed on " . get_class($this)
        );
    }
}
