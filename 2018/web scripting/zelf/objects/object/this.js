"use strict";

let object = {
    param: "var1",

    fun: function() {
        console.log("function output: " + this.param);
    }
}

let funOutside = object.fun;
console.log(funOutside());
