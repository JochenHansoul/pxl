'use strict';

// classes
const C_FOCUS = "input-focus";
const C_BLUR = "input-blur";
const C_CHANGE_BUTTON = "change-button-active";
// buttons
const B_SUBMIT = document.getElementById("submit-button");
const B_RESET = document.getElementById("reset-button");
const B_CHANGE = document.getElementById("change-button");
// input
const I_ARRAY = [
    document.getElementById("first-name"),
    document.getElementById("last-name"),
    document.getElementById("address")
];

try {
    // adding eventListeners for all the input elements
    for (let input of I_ARRAY) {
        // when input field is selected all text is removed, new text is red and change button turns grey
        input.addEventListener("focus", function () {
            input.value = "";
            input.classList.remove(C_BLUR);
            input.classList.add(C_FOCUS);
            B_CHANGE.classList.add(C_CHANGE_BUTTON)
        });
        // when input field is no longer selected text returns to black, background to red and change button returns to normal
        input.addEventListener("blur", function () {
            B_CHANGE.classList.remove(C_CHANGE_BUTTON);
            input.classList.remove(C_FOCUS);
            input.classList.add(C_BLUR);
        });
    }
    B_SUBMIT.addEventListener("click", function () {
        window.alert("Bedankt om het formulier te verzenden")
    });
    B_RESET.addEventListener("click", function () {
        window.alert("Alle gegevens werden gewist")
    });
} catch (e) {
    console.log(e)
}