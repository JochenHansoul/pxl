<?php

declare(strict_types=1);

class StrictClass
{
	private int $i;

	public function __construct(int $i)
	{
		$this->i = $i;
	}

	public function getValue(): int
	{
		return (string) $this->i;
	}
}
