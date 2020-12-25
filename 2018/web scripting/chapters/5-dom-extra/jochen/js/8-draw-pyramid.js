'use strict';

const removeAllChildren = node => {
    while (node.firstChild) {
        node.firstChild.remove();
    }
};

const drawPyramid = (number, min, max, symbol , outputNode) => {
    removeAllChildren(outputNode);
    if (number >= min && number <= max) {
        for (let i = 1; i <= number; i++) {
            outputNode.appendChild(document.createTextNode(symbol.repeat(i)));
            outputNode.appendChild(document.createElement("br"))
        }
    } else {
        outputNode.appendChild(document.createTextNode("Foutieve waarde ingegeven"));
    }
};

/*
24 march 2019
made by Jochen Hansoul
const drawPyramid = (O_MOUNTAINS, id, min, max, number, symbol) => {
    let output = document.createElement("split");
    output.id = id;
    output.name = "draw_pyramid";
    if (number >= min && number <= max) {
        for (let i = 1; i <= number; i++) {
            output.appendChild(document.createTextNode(symbol.repeat(i)));
            output.appendChild(document.createElement("br"))
        }
        O_MOUNTAINS.replaceChild(output, document.getElementById(id))
    }  else {
        output.appendChild(document.createTextNode("Foutieve waarde ingegeven"));
        O_MOUNTAINS.replaceChild(output, document.getElementById(id))
    }
};
output.firstChild = "";
parent.firstChild.remove() // removes the first child
parent.removeChild(parent.ChildNodes[0]);
.clear();
.nodeValue
parent.removeChild(child)
 */