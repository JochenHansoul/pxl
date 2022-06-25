<?php

declare(strict_types=1);

namespace data;

trait ComparableWithSameOrChildClass
{
    private function isSameOrChildclass(object $o): bool
    {
        return get_class($o) === get_called_class()
                || is_subclass_of($o, get_called_class());
    }
}
