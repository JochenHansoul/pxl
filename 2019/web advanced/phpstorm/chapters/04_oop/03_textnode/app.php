<?php

require_once "vendor/autoload.php";

use TextNode\TextNode;

try {
    $textNode = TextNode::makeNode("a");
    $textNode->addNode("b");
    $textNode->addNode("c");
    $textNode->printAll();
    echo "\n";
    $textNode->printTextNodeAt(2);
    echo "\n";
} catch (Exception $e) {
    echo $e->getMessage() . "\n";
}
