'use strict';

const removeAllChildren = node => {
    while (node.firstChild) { // or: .hasChildNodes()
        node.firstChild.remove() // or maybe faster: .removeChild()
    }
};

let span = document.createElement("span");
span.appendChild(document.createTextNode("this is a span"));

let p = document.createElement("p");
/*
p.appendChild(document.createTextNode("first part "));
p.appendChild(span);
p.appendChild(document.createTextNode(" second part"));
*/
// werkt hetzelfde
p.append(document.createTextNode("first part "), span, document.createTextNode(" second part"));

document.getElementById("output").appendChild(p);

// al de kinderen verwijderen werkt ook
//removeAllChildren(p);