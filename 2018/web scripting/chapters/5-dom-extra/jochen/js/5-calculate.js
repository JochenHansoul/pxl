'use strict';

class InputError extends Error {}

const removeAllChildren = node => {
    while (node.firstChild) {
        node.firstChild.remove()
    }
};

const calculate = (firstInput, secondInput, outputNode) => {
    try {
        removeAllChildren(outputNode);
        let number1 = parseInt(firstInput.value);
        let number2 = parseInt(secondInput.value);
        if (!(number1 && number2)) throw new InputError("U hebt niet al de getallen ingegeven");
        if (isNaN(number1) || isNaN(number2)) throw new InputError("U hebt geen correcte getallen ingegeven"); // GEEN input1 == NaN !!!
        outputNode.appendChild(document.createTextNode(number1 * number2 + ""));
    } catch (e) {
        // als er geen output O_MOUNTAINS is geeft dit een foutmelding
        // beter fout naar boven gooien
        outputNode.appendChild(document.createTextNode(e))
    }
};

/*
const calculate = (firstInput, secondInput, outputNode) => {
    removeAllChildren(outputNode);
    let number1 = parseInt(firstInput.value);
    let number2 = parseInt(secondInput.value);
    if (number1 && number2) {
        if (isNaN(number1) || isNaN(number2)) { // GEEN input1 == NaN !!!
            outputNode.appendChild(document.createTextNode("U hebt geen correcte getallen ingegeven"));
        } else {
            outputNode.appendChild(document.createTextNode(number1 * number2 + ""));
        }
    } else {
        outputNode.appendChild(document.createTextNode("U hebt niet al de getallen ingegeven"));
    }
};
 */