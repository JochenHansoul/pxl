'use strict';

/*
geeft een true terug als het woord boek erin staat, false als het niet erin staat
ik denk dat het stopt wanneer de eerste return statement true opleverd
 */

let counter = 0;

function talksAbout(node, string) {
    counter++;
    console.log(counter);
    if (node.nodeType === document.ELEMENT_NODE) {
        for (let i = 0; i < node.childNodes.length; i++) {  // doorloopt al de childnodes
            if (talksAbout(node.childNodes[i], string)) {   // geneste functie, controleerd één voor één childnodes. (hier komt de true of false in voor "book" gevonden)
                return true;                                // als true is returnt het een serie van trues
            }                                               // als false returnt geen true en gaat naar volgende O_MOUNTAINS
        }                                                   // op einde geen "book" tegengekomen returnt valse
        return false; // als volledig aantal childnodes heeft afgelopen (of als geen heeft) returnt false
    } else if (node.nodeType === document.TEXT_NODE) {       // wat met nodes in de textnode <strong>, <em>?
        return node.nodeValue.indexOf(string) > -1;
    }
    // wat als de text_node leeg is? geen return false? --> returnt undefined
}

console.log(talksAbout(document.body, "book"));