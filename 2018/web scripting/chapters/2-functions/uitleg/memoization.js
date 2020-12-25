/*
Memoization is an optimization technique used primarily to speed up computer programs by storing the results of expensive function calls.
*/
let waarden = [1, 1];
function fibonacci(getal){
    if (waarden[getal] === undefined){
        let resultaat = fibonacci(getal - 1) + fibonacci(getal - 2);
        waarden[getal] = resultaat;
        return resultaat;
    } else {
        return waarden[getal];
    }
}
console.log("memoization :-)");
console.log("fibonacci(100)= " + fibonacci(50));