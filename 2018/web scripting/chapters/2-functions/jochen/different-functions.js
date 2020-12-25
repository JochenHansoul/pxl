'use strict';

functionDeclaration();
//functionExpressi();

function functionDeclaration() {
    let a = 0;
}

const functionExpressi = function () {
    let a = 0;
};

const varFunct = function namedFunction() {
    console.log("name")
};

varFunct();

(function () {
    let b = 0;
    console.log("inside")
})(); // create function at the same time it is called

// met () achteraan geeft undefined want de functie return niets
console.log(functionDeclaration); // [Function: de naam]
console.log(functionExpressi); // [Function: de naam]

console.log(typeof functionExpressi);