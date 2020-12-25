'use strict';

const E_FIRST_NAME = document.getElementById("first-name");
const E_LAST_NAME = document.getElementById("last-name");
const E_OUTPUT = document.getElementById("welcome-message-output");

const removeAllChildren = node => {
    while (node.firstChild) { // or: .hasChildNodes()
        node.firstChild.remove() // or maybe faster: .removeChild()
    }
};

/*
const generateWelcomeMessage = (firstName, lastName, O_MOUNTAINS) => {
    removeAllChildren(O_MOUNTAINS);
    try {
        if (!firstName && !lastName) throw new Error("Fill in first name and last name.");
        if (!firstName) throw new Error("Fill in first name.");
        if (!lastName) throw new Error("Fill in last name.");
        O_MOUNTAINS.appendChild(document.createTextNode(`Welcome, ${firstName} ${lastName}.`));
    } catch (e) {
        O_MOUNTAINS.appendChild(document.createTextNode("Input" + e));
    }
};
*/

const generateWelcomeTextNode = (firstName, lastName) => {
    if (!firstName && !lastName) throw new Error("Fill in first name and last name.");
    if (!firstName) throw new Error("Fill in first name.");
    if (!lastName) throw new Error("Fill in last name.");
    return document.createTextNode(`Welcome, ${firstName} ${lastName}.`)
};


document.getElementById("welcome-message-button").addEventListener("click", () => {
    // maybe this method is better becouse it allows more flexibility between the output O_MOUNTAINS and the O_MOUNTAINS for the error message
    // it also doesn't give any warnings with the throw error cough locally
    removeAllChildren(E_OUTPUT);
    try {
        E_OUTPUT.appendChild(generateWelcomeTextNode(E_FIRST_NAME.value, E_LAST_NAME.value))
    } catch (e) {
        E_OUTPUT.appendChild(document.createTextNode("Input" + e));
    }
});