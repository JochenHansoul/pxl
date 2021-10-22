"use strict";

let object = {
    param1: "var1",

    fun1: function() {
        console.log("this is a function");
    },
    fun2() {
        console.log("this is also a function");
    }
}

console.log(object.param1);
object.fun1();
object.fun2();

console.log("function definition:");
console.log(object.fun1);
console.log(object.fun2);

console.log("function oproepen:");
let fun = object.fun1;
fun();
