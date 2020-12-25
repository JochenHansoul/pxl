'use strict';

// rij.push(teller)
//Math.pow, Math.squairRoot


const telB = function (woord) {
    let som = 0;
    for (let i = 0; i < woord.length; i++) {
        if (woord[i] === "B") {
            som++
        }
    }
    return som
};
console.log(telB("ganzenBordBBBaaabbb"));


const telChar = function (woord, symbool) {
    let som = 0;
    for (let i = 0; i < woord.length; i++) {
        if (woord[i] === symbool) {
            som++;
        }
    }
    return som
};
console.log(telChar("gaaanzen", "a"));


const maakRij = function (min, max) {
    let array = [];
    if (min < max) {
        for (let i = 0; i <= max - min; i++) {
            array.push(i + min);
        }
    }
    return array
};
console.log(maakRij(1, 5));


const maakRij2 = function (min, max, step) {
    let array = [];
    let stepSize = step || 1;
    console.log(stepSize);
    if (stepSize < 0) {
        if (min > max) {
            for (let i = min; i >= max; i += stepSize) {
                array.push(i);
            }
        }
        return array
    } else {
        if (min < max) {
            for (let i = 0; i <= max - min; i += stepSize) {
                array.push(i + min);
            }
        }
        return array
    }
};
console.log(maakRij2(20, 10, -2));


const reverseArray = array => {
    let newArray = [];
    for (let i = array.length - 1; i >= 0; i--) {
        newArray.push(array[i])
    }
    return newArray
};
let array1 = [1, 2, 3, 4, 5];
console.log(reverseArray(array1));


const berekenAfstand = (punt1, punt2) => {
    return Math.sqrt(Math.pow(punt1.x - punt2.x, 2) + Math.pow(punt1.y - punt2.y, 2))
};
let punt1 = {x: 1, y: 1};
let punt2 = {x: 2, y: 2};
console.log(berekenAfstand(punt1, punt2));