"use strict";

console.log("this:");
console.log(this); // {}

let protoObject = {
    method() {
        return this;
    }
}
let o = Object.create(protoObject);
o.name = "name";
console.log("this in object:");
console.log(o.method()); // returns the propertys of the own object. {} if empty
