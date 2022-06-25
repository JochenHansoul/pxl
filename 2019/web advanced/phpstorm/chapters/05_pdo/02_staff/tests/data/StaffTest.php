<?php

declare(strict_types=1);

namespace data;

use PHPUnit\Framework\TestCase;

final class StaffTest extends TestCase
{
    public function testClassConstructor(): void
    {
        $staff = new Staff(1, "first1@mail.com", "first1", "last1");

        $this->assertSame(1, $staff->id);
        $this->assertSame("first1@mail.com", $staff->email);
        $this->assertSame("first1", $staff->nameFirst);
        $this->assertSame("last1", $staff->nameLast);
    }

    public function testFullName(): void
    {
        $staff = new Staff(1, "first1@mail.com", "first1", "last1");
        $this->assertSame("first1 last1", $staff->getFullName());
    }

    public function testIdError(): void
    {
        $this->expectError();
        $message = "Cannot modify readonly property data\Staff::$id";
        $this->expectErrorMessageMatches($message);
        $staff = new Staff(1, "first1@mail.com", "first1", "last1");
        \trigger_error($staff->id = 2, \ERROR);
    }

    public function testEmailError(): void
    {
        $this->expectError();
        $message = "Cannot modify readonly property data\Staff::$email";
        $this->expectErrorMessageMatches($message);
        $staff = new Staff(1, "first1@mail.com", "first1", "last1");
        \trigger_error($staff->email = "mutate", \ERROR);
    }

    public function testNameLastError(): void
    {
        $this->expectError();
        $message = "Cannot modify readonly property data\Staff::$nameLast";
        $this->expectErrorMessageMatches($message);
        $staff = new Staff(1, "first1@mail.com", "first1", "last1");
        \trigger_error($staff->nameLast = "mutate", \ERROR);
    }

    public function testNameFirstError(): void
    {
        $this->expectError();
        $message = "Cannot modify readonly property data\Staff::$nameFirst";
        $this->expectErrorMessageMatches($message);
        $staff = new Staff(1, "first1@mail.com", "first1", "last1");
        \trigger_error($staff->nameFirst = "mutate", \ERROR);
    }
}
