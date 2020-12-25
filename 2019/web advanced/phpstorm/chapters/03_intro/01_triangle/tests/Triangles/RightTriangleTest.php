<?php

namespace UnitTestFiles\Test\Triangles;

use PHPUnit\Framework\TestCase;

use function Triangles\rightTriangle;

class RightTriangleTest extends TestCase
{
    public function testOneLine()
    {
        $line = rightTriangle("$", 1);
        $this->assertEquals("$\n", $line);
    }

    public function testTwoLines()
    {
        $line = rightTriangle("@", 2);
        $this->assertEquals(" @\n@@\n", $line);
    }

    public function testThreeLines()
    {
        $line = rightTriangle("+", 3);
        $this->assertEquals("  +\n ++\n+++\n", $line);
    }

    public function testMultipleSymbols()
    {
        $line = rightTriangle("@+", 3);
        $this->assertEquals("  @+\n @+@+\n@+@+@+\n", $line);
    }
}
