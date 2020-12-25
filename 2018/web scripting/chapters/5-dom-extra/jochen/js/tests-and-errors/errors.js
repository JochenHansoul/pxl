'use strict';

class InputError extends Error {}


const errorFunction = () => {
    //throw new Error("inside function");
    try {
        throw new InputError("error caught in function")
    } catch (e) {
        console.log(e instanceof InputError ? `Local function (InputError): ${e.message}`
            : `Local function ${e.name} ${e.message}`)
    }
};


try {
    errorFunction();
    throw new InputError("error outside function");
    //console.log("reached the end")
} catch (e) {
    console.log(e instanceof InputError ? `(inputError): ${e.message}` : `${e.name} ${e.message}`)
}