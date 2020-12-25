<?php

namespace UnitTestFiles\Test\Triangles;

//require_once "../src/Functions/triangle.php"; // werkt ineens niet meer
//require_once "vendor/autoload.php";

use PHPUnit\Framework\TestCase;

use function Triangles\leftTriangle;

class LeftTriangleTest extends TestCase
{
    public function testOneLine()
    {
        $line = leftTriangle("$", 1);
        $this->assertEquals("$\n", $line);
    }

    public function testTwoLines()
    {
        $line = leftTriangle("@", 2);
        $this->assertEquals("@\n@@\n", $line);
    }

    public function testThreeLines()
    {
        $line = leftTriangle("+", 3);
        $this->assertEquals("+\n++\n+++\n", $line);
    }

    public function testMultipleSymbols()
    {
        $line = leftTriangle("@+", 3);
        $this->assertEquals("@+\n@+@+\n@+@+@+\n", $line);
    }
}
