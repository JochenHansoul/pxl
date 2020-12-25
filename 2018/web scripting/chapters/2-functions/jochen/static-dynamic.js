'use strict';

function addTwo(x) {
    x += 2;
}

const addTwoStatic = x => {
    x += 2;
};

let x = 0;
let xStat = 0;
addTwo(x);
addTwoStatic(xStat);

console.log(x);
console.log(xStat);