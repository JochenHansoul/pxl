'use strict';

class Person {
    //#firstName; // heb hier geprobeerd een prive veld te maken. lijkt wel prive te maken maar geeft een syntaxError: Invalid or unexpected token
    constructor(firstName = "tests-and-errors", name, birthDate = new Date()) {
        //this.#firstName = firstName;
        this._firstName = firstName;
        this._name = name;             // geen let maar this.
        this._birthDate = birthDate; // zij vindt backticks veiliger dan + "-" +
    }
    // setters
    set name(name) {
        this._name = name;
    }
    set firstName(firstName) {
        this._firstName = firstName
    }
    set birthDate(birthDate) { // birthDate niet birthDateString
        this._birthDate = birthDate
    }
    // getters
    get name() {
        return this._name
    }
    get firstName() {
        return this._firstName
    }
    get birthDate() {
        return this._birthDate
    }
    // methoden
    calculateAge() {
        return new Date(Date.now()).getFullYear() - this._birthDate.getFullYear()
    }
    print() {
        console.log(`first name: ${this._firstName}, name: ${this._name}, age: ${this.calculateAge()}`)
    }
}


let person1 = new Person("Jochen", "hansoul", new Date("1990-05-11"));
person1.print();

person1._firstName = "nieuwe naam";
person1.print();

/*let person2 = Object.create(person1);
person2.name = "Gaens";
person2.firstName = "Patrick";
person2.birthDate = new Date("1981-04-17");
person2.print();

let person3 = new Person("jochen2");
person3.print();

let person4 = new Person();
person4.print();*/