'use strict';

const I_DAY = document.getElementById("day");
const O_DAY = document.getElementById("output-day");
const B_DAY = document.getElementById("button-get-day");

const removeAllChildren = node => {
    while(node.firstChild) {
        node.firstChild.remove()
    }
};

const whichDayOfWeek = day => {
    console.log(day.toLowerCase());
    switch (day.toLowerCase()) {
        case "maandag":
            //case "Maandag":
            return "is de eerste dag van de week";
        case "dinsdag":
            return "is de tweede dag van de week";
        case "woensdag":
            return "is de derde dag van de week";
        case "donderdag":
            return "is de vierde dag van de week";
        case "vrijdag":
            return "is de vijfde dag van de week";
        case "zaterdag":
            return "is de zesde dag van de week";
        case "zondag":
            return "is de zevende dag van de week";
        default:
            return "is de niet-bestaande dag van de week";
    }
};

B_DAY.addEventListener("click", function () {
    removeAllChildren(O_DAY);
    O_DAY.appendChild(document.createTextNode(whichDayOfWeek(I_DAY.value)))
});


/*const whichDayOfWeek = (day, outputNode) => {
    switch (day) {
        case "maandag":
            outputNode.appendChild(document.createTextNode("is de eerste dag van de week"));
            break;
        case "dinsdag":
            outputNode.appendChild(document.createTextNode("is de tweede dag van de week"));
            break;
        case "woensdag":
            outputNode.appendChild(document.createTextNode("is de derde dag van de week"));
            break;
        case "donderdag":
            outputNode.appendChild(document.createTextNode("is de vierde dag van de week"));
            break;
        case "vrijdag":
            outputNode.appendChild(document.createTextNode("is de vijfde dag van de week"));
            break;
        case "zaterdag":
            outputNode.appendChild(document.createTextNode("is de zesde dag van de week"));
            break;
        case "zondag":
            outputNode.appendChild(document.createTextNode("is de zevende dag van de week"));
            break;
        default:
            outputNode.appendChild(document.createTextNode("is de niet-bestaande dag van de week"));
            break;
    }
};*/
