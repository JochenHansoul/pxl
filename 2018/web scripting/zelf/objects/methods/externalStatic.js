"use strict";

const toString = () => {
    return this.firstName + " " + this.lastName;
}

let person = {
    firstName: "first name",
    lastName: "last name",
    toString
}

console.log(person.firstName);
console.log(person.toString());
