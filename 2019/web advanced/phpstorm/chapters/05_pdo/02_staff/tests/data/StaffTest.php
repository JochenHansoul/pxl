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

    public function testFullName(): void
    {
        $staff = new Staff(1, "first1@mail.com", "first1", "last1");
        $this->assertSame("first1 last1", $staff->getFullName());
    }

    public function testEquals(): void
    {
        $staff = new Staff(1, "first1@mail.com", "first1", "last1");
        $same = new Staff(1, "first1@mail.com", "first1", "last1");
        $otherId = new Staff(2, "first1@mail.com", "first1", "last1");
        $otherEmail = new Staff(1, "first2@mail.com", "first1", "last1");
        $otherNameFirst = new Staff(1, "first1@mail.com", "first2", "last1");
        $otherNameLast = new Staff(1, "first1@mail.com", "first1", "last2");
        $this->assertTrue($staff->equals($same));
        $this->assertFalse($staff->equals($otherId));
        $this->assertFalse($staff->equals($otherEmail));
        $this->assertFalse($staff->equals($otherNameFirst));
        $this->assertFalse($staff->equals($otherNameLast));
    }
}
