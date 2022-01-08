"use strict";

console.log("object literal:");
console.log({});
// {}

console.log("Object.getPrototypeOf({}):");
console.log(Object.getPrototypeOf({}));
// {}

console.log("Object.prototype:");
console.log(Object.prototype);
// {}

console.log("==:");
console.log(Object.getPrototypeOf({}) == Object.prototype);
// true

console.log("===:");
console.log(Object.getPrototypeOf({}) === Object.prototype);
// true
