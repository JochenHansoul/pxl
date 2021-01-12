<?php

function staticFunction()
{
	static $i = 0;
	$i++;
	return $i;
}


echo staticFunction() . "\n";
echo staticFunction() . "\n";
echo staticFunction() . "\n";
