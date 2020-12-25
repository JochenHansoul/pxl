'use strict';

let name = "jochen";
let nameIterator = name[Symbol.iterator]();
let element = nameIterator; // stopt dit een waarde in element?
//console.log(element.value);
while (!element.done) {
    console.log(element.value);
    element = nameIterator.next()
}