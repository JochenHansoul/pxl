<?php

function getGreetingFunction(): object
{
    $timeOfDay = "morning";
    return function($name) use (&$timeOfDay): string
    {
        $timeOfDay = ucfirst($timeOfDay);
        return "Good $timeOfDay, $name!";
    };
};

$greetingFunction = getGreetingFunction();
//echo "${greetingFunction('Fred')}\n"; PHP Fatal error:  Uncaught Error: Call to undefined function greetingFunction()
echo "{$greetingFunction('Fred')}\n"; // Displays "Good Morning, Fred!"
