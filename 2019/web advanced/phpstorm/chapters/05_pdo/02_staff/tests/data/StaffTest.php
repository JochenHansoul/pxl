<?php

declare(strict_types=1);

namespace data;

use PHPUnit\Framework\TestCase;

class StaffTest extends TestCase
{
    public function testId()
    {
        $staff = new Staff(1, "first1", "last1");
        $this->assertTrue($staff->id== 1);
    }

    public function testFirstName()
    {
        $staff = new Staff(1, "first1", "last1");
        $this->assertTrue($staff->nameFirst == "first1");
    }

    public function testLastName()
    {
        $staff = new Staff(1, "first1", "last1");
        $this->assertTrue($staff->nameLast == "last1");
    }

    public function testFullName()
    {
        $staff = new Staff(1, "first1", "last1");
        $this->assertTrue($staff->getFullName() == "first1 last1");
    }
}
