// veel te omslagtig
let symbool = "#";
for (let i = 0; i < 8; i++) {
    uitvoer = "";
    for (let j = 0; j < 8; j++) {
        if ((i + j) % 2 === 0) {
            uitvoer += symbool;
        } else {
            uitvoer += " ";
        }
    }
    console.log(uitvoer);
}

/*let grootte = 8;
let line = "";
for (let row = 0; row < grootte; row++) {
    if (row % 2 == 0) {

    }
    // nog iets
}*/
