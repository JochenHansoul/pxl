'use strict';

try {
    let a = 3, b;
    a = 5;
    b = 7;
    console.log("this is executed");
    throw new Error("c is wrong");
    c = 9;
    console.log("this is not executed?")
} catch (error) {
    console.log(error)
} finally {
    console.log("this is always executed regardless of error or not")
}