"use strict"

let global;
if (true) {
    let localTrue = "true"
} else {
    let localFalse = "false"
}
console.log(global)
//console.log(localTrue) // ReferenceError: localTrue is not defined
//console.log(localFalse) // ReferenceError: localFalse is not defined
