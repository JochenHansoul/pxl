<?php

namespace UnitTestFiles\Test\Classes;

//require_once "../src/Classes/Foo.php"; // werkt ineens niet meer
//require_once "vendor/autoload.php";

use Classes\Foo;
use PHPUnit\Framework\TestCase;

class FooTest extends TestCase
{
    public function testToString()
    {
        $foo = new Foo("test1");
        $this->assertEquals("test1", $foo->toString());
    }

    public function testReturnTrue()
    {
        $foo = new Foo("test1");
        $this->assertTrue($foo->returnTrue());
    }
}
