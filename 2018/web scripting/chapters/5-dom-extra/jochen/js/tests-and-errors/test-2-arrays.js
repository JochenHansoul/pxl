'use strict';

const amountOfColors = 6;

let line = "red,red,red,red,red,red,yellow,yellow,yellow,yellow,yellow,yellow";
let split = line.split(',');
//let colorsArray = colors.split(',');

console.log(split + " length: " + split.length);

let rounds = split.length / amountOfColors;
for (let i = 0; i < rounds; i++) {
    let colorsOneRound = [];
    for (let j = 6 * i; j < 6 * (i + 1); j++) {
        colorsOneRound.push(split[j]);
    }
    console.log(colorsOneRound)
}