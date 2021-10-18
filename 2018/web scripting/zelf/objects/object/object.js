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
