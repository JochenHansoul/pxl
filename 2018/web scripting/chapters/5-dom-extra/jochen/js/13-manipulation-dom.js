'use strict';

// better name: removeChildren
const removeAllChilds = node => {
    while (node.firstChild) {
        node.firstChild.remove()
    }
};

const reverseSentence = (string, filter, node, nodeFilter, ...classNames) => {
    removeAllChilds(node);
    removeAllChilds(nodeFilter);

    let split = string.split(" ");
    let filterArray = filter.split(" ");
    split.reverse();
    let count = 0;
    for (let i = 0; i < split.length; i++) {
        let newSpan = document.createElement('span');
        for (let j = 0; j < classNames.length; j++) { // adding class names
            newSpan.className += classNames[j] +" ";
        }
        for (let j = 0; j < filterArray.length; j++) { // filter -> ghost
            if (split[i].toLowerCase() == filterArray[j].toLocaleLowerCase()) {
                newSpan.className += 'ghost';
                count++;
                j = filterArray.length;
            }
        }
        newSpan.appendChild(document.createTextNode(split[i]));
        node.append(newSpan);
    }
    nodeFilter.append(document.createTextNode(count + " word(s) filtered."));
};

console.log(reverseSentence("string"));


/*const reverseSentence = (string, parentNode, id, styleClass) => {
    let split = string.split(" ");
    split.reverse();
    let output = document.createElement('output');
    output.id = id;
    for (let i = 0; i < split.length; i++) {
        let span = document.createElement('span');
        span.C_GROW = styleClass;
        span.appendChild(document.createTextNode(split[i]));
        output.append(span);
    }
    parentNode.replaceChild(output, document.getElementById(id));
};*/