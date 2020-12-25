'use strict';

class InputError extends Error {}
class ArithmeticError extends Error {}

function invert(number){
    if (typeof number != 'number') throw new InputError("not a number");
    if (number === 0) throw new ArithmeticError("division by 0");
    return 1 / number;
}


try{
    let result = invert(0);
    //let result = invert("a")
    console.log(`result = ${result}`);
} catch(e) {
    console.log(e.constructor); // [Function: ArithmeticError]
    console.log(e.constructor.name); // ArithmeticError
    if (e instanceof InputError) {
        console.log(`InputError: ${e.message}`);
    } else if (e instanceof ArithmeticError) {
        console.log(`ArithmeticError: ${e.message}`);
    }
}