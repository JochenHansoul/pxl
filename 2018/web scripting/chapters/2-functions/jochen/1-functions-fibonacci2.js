"use strict"

class InputError extends Error {}


const innerFibonacci = (n, memo = []) => {
    return memo[n] ? memo[n] : n <= 1 ? 1 : memo[n] = innerFibonacci(n - 1, memo) + innerFibonacci(n - 2, memo);
};


const fibonacci = n => {
    if (!Number.isInteger(n)) {
        throw new InputError("Number must be an integer")
    }
    if (n < 0) {
        throw new InputError("Number must be equal or higher then zero")
    }
    return innerFibonacci(n)
}


try {
    let n = 500;
    console.log(fibonacci(n))
} catch (e) {
    console.log(`${e.constructor.name}: ${e.message}`);
}