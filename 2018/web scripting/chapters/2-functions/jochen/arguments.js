'use strict';

const noArgumentsGiven = (x, b) => {
    x += b;
    return x
};


const printValues = (a, b) => console.log(a, b);


const functionWithDefaultValues = (num1, num2 = 2, string1) => {
    console.log(num1, num2, string1);
}


console.log(noArgumentsGiven()); // NaN
printValues(undefined, "b"); // undefined 'b'
functionWithDefaultValues(1, undefined, "hello"); //1 2 'hello'