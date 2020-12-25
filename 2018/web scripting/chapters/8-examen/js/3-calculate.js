// naam: Jochen Hansoul
'use strict';
// hint: if( ! /^\d+$/.test(ingave) )

const buttonBereken = document.getElementById("button_start_rekenen");
const ingaveBerekening = document.getElementById("input_aantal");
const outputVermenigvuldiging = document.getElementById("vermenigvuldigingen");

const removeAllChildren = node => {
    while (node.firstChild) {
        node.firstChild.remove()
    }
};

const handleKeyupInput = event => {
    if( ! /^\d+$/.test(event.target.value) ) {
        event.target.style = "color:red"
    } else {
        event.target.style = ""
    }
};

const handleClick = () => {
    try {
        removeAllChildren(outputVermenigvuldiging);
        let ingave = ingaveBerekening.value;
        if( ! /^\d+$/.test(ingave) ) throw new Error("verkeerde ingave voor aantal");
        outputVermenigvuldiging.appendChild(document.createElement("hr"));
        for (let i = 0; i < ingave; i++) {
            let div = document.createElement("div");
            let getal1 = parseInt(10 * Math.random());
            let getal2 = parseInt(10 * Math.random());
            let input = document.createElement("input");
            input.type = "tekst";
            // add eventlistener
            input.addEventListener("keyup", handleKeyupInput); // het target wordt al automatisch doorgestuurd!
            div.appendChild(document.createTextNode(`${getal1} * ${getal2} = `));
            div.appendChild(input);
            outputVermenigvuldiging.appendChild(div);
            outputVermenigvuldiging.appendChild(document.createElement("hr"))
        }
    } catch (e) {
        outputVermenigvuldiging.appendChild(document.createTextNode(e))
    }
};

const handleLoad = () => {
    buttonBereken.addEventListener("click",handleClick );
};

window.addEventListener("load", handleLoad);