<?php

namespace TextNode;

class TextNode
{
    private string $text;
    private ?TextNode $nextNode = null;
    // $nextNode bevat object van eigen classe dat op zijn beurt weer een object
    // van zichzelf kan bevatten (verwijzing naar volgende tekstnode)

    private function __construct(string $text)
    {
        $this->text = $text;
    }

    public static function makeNode($text): TextNode
    {
        return new self($text);
    }

    public function addNode($text): void
    {
        $this->nextNode === null ? $this->nextNode = $this::makeNode($text)
            : $this->nextNode->addNode($text);
    }

    public function printAll(): void
    {
        echo $this->text;
        if ($this->nextNode !== null) {
            $this->nextNode->printAll();
        }
    }

    public function printTextNodeAt(int $i): void
    {
        if ($i === 0) {
            echo $this->text;
        } else if ($i > 0) {
            if ($this->nextNode !== null) {
                $this->nextNode->printTextNodeAt(--$i);
            } else {
                throw new \Exception("Input value is to height");
            }
        } else {
            throw new \Exception("input value may not be less than zero");
        }

        // Het is logischer om te correcte waarde te nemen en dan het juiste te returned
        // dan telkens een foute waarde te nemen en een fout op de werpen.
        // iemand die de code leest ziet zo wat de code hoort te doen en de fouten
        // worden naar beneden geduwd.
        // if (response.status() == 201) { return response.json(); } else ...

        /*if ($i < 0) {
            throw new \Exception("input value may not be less than zero");
        } elseif ($i === 0) {
            echo $this->text;
        } elseif ($this->nextNode === null) {
            throw new \Exception("Input value is to height");
        } else {
            $this->nextNode->printTextNodeAt(--$i);
        }*/
    }
}
