<?php

declare(strict_types=1);

namespace pdo;

use data\Staff;
use PHPUnit\Framework\TestCase;

final class StaffPDOTest extends TestCase
{
    public function testClassConstructor(): void
    {
        $staffPDO = null;
        try {
            $staffPDO = new StaffPDO();
        } catch (\PDOException $e) {
            echo $e->getMessage();
        }
        $this->assertNotNull($staffPDO);
    }

    public function testGetAllStaff(): void
    {
        $staffMembers = [];
        try {
            $staffPDO = new StaffPDO();
            $staffMembers = $staffPDO->getAllStaff();
        } catch (\PDOException $e) {
            echo $e->getMessage();
        }
        $this->assertSame(3, \count($staffMembers));

        $staffMember = $staffMembers[0];
        $this->assertSame(1, $staffMember->id);
        $this->assertSame("prefix1@mail.com", $staffMember->email);
        $this->assertSame("Martin", $staffMember->nameFirst);
        $this->assertSame("Freeman", $staffMember->nameLast);

        $staffMember = $staffMembers[1];
        $this->assertSame(2, $staffMember->id);
        $this->assertSame("prefix2@mail.com", $staffMember->email);
        $this->assertSame("Feynman", $staffMember->nameFirst);
        $this->assertSame("Tomson", $staffMember->nameLast);

        $staffMember = $staffMembers[2];
        $this->assertSame(3, $staffMember->id);
        $this->assertSame("prefix3@mail.com", $staffMember->email);
        $this->assertSame("Graves", $staffMember->nameFirst);
        $this->assertSame("Wonder", $staffMember->nameLast);
    }
}
