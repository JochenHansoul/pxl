"use strict";

const fibonacci = getal => {
    if (getal === 0) {
        return 1;
    } else if (getal === 1) {
        return 1;
    } else {
        return fibonacci(getal - 2) + fibonacci(getal - 1);
    }
};


const fibonacci2 = nr => {
    return nr === 0 || nr === 1 ? 1 : fibonacci2(nr - 2) + fibonacci2(nr - 1);
}


// Memoization
const fibonacci3 = (n, memo = []) => {
    if (memo[n]) {
        return memo[n];
    }
    if (n <= 1) {
        return 1;
    }
    return memo[n] = fibonacci3(n - 1, memo) + fibonacci3(n - 2, memo);
};


const fibonacci4 = (n, memo = []) => {
    return memo[n] ? memo[n] : n <= 1 ? 1 : memo[n] = fibonacci4(n - 1, memo) + fibonacci4(n - 2, memo);
};


console.log(fibonacci(5));
console.log("\nfibonacci (later aangemaakt):");
console.log(fibonacci3(50));