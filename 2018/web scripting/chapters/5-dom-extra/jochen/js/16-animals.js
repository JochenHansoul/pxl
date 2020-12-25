'use strict';

const C_GROW = "grow-big";
const E_TITLE = document.getElementById("name-animal");
const E_IMAGES = document.body.querySelectorAll("img");

const setOriginalSize = () => {
    for (let image of E_IMAGES) {
        image.classList.remove(C_GROW)
    }
};


try {
    // puts eventlisteners on all images
    for (let image of E_IMAGES) {
        image.addEventListener("dblclick", () => {
            setOriginalSize(); //when double clicked removes E_GROW (puts all images back to original size)
            image.classList.add(C_GROW);
            E_TITLE.innerText = image.alt;
        });
        image.addEventListener("click", () => {
            if (image.classList.contains(C_GROW)) {
                image.classList.remove(C_GROW);
                E_TITLE.innerText = ""
            }
        })
    }
} catch (e) {
    console.log(e)
}