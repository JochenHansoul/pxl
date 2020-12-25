"use strict";

let string = /"qsfqzeeee""/;
let format = /[`!@#$%^&*()_+\-=\[\]{};:"\\|,.<>\/?~]/;
//            ^                                       ^
console.log(format.test("hell' oworld") + "<br/>");