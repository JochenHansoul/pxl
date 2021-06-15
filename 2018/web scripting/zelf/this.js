"use strict";

console.log("this:");
console.log(this);

let protoObject = {
    method() {
        return this;
    }
}
let o = Object.create(protoObject);
console.log("this in object:");
console.log(o.method());
