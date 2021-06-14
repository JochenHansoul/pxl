"use strict";

let person = {
    firstName: "first",
    lastName: "last",
    toString() {
        this.firstName + " " + this.lastName;
    }
}

console.log(person.toString());
