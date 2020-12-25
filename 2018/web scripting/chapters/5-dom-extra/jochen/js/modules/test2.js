'use strict';

exports.uppercase = text => text.toUpperCase();
exports.alphabet = "abcdefghijklmnopqrstuvwxyz";
exports.plus = (x, y) => {return x + y};
exports.complicatedSum = (...getallen) => {
    let sum = 0;
    for (let getal of getallen) {
        sum += getal
    }
    return sum
};