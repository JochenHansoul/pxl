'use strict';

const INPUT_FORM = document.getElementById("input-form");
const EXAMPLE_TEXT = document.getElementById("example-text");

const FONT_STYLE = document.getElementById("font-style");
const FONT_SIZE = document.getElementById("font-size");

const changeFontAndSize = (element, style, size) => {
    element.style.fontFamily = style;
    element.style.fontSize = size + "px";
};

INPUT_FORM.addEventListener("change", function () {
    changeFontAndSize(EXAMPLE_TEXT, FONT_STYLE.value, FONT_SIZE.value)
});