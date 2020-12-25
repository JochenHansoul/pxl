'use strict';

const I_NUMBER = document.getElementById("input-number");
const O_NUMBER = document.getElementById("output-number");
const B_NUMBER = document.querySelectorAll("input")[1];

const removeAllChildren = node => {
    while (node.firstChild) {
        node.firstChild.remove()
    }
};


const generateUnevenNumbers = (input, output) => {
    removeAllChildren(output);
    let number = parseInt(input.value);
    if (number > 0 && number <= 50) {
        for (let i = 1; i <= number; i += 2) {
            output.appendChild(document.createTextNode(i + " "));
        }
    } else {
        output.appendChild(document.createTextNode("Het opgegeven getal ligt buiten de gegeven waarde"));
    }
};


B_NUMBER.addEventListener("click", function () {
    generateUnevenNumbers(I_NUMBER, O_NUMBER)
});