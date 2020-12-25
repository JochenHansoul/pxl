'use strict';

/*
this._name als voluit met setName : functie () {} schrijft
this.name = name voor zonder functie
 */

let person = {
    _name: "tests-and-errors",
    _firstName: "tests-and-errors",
    _birthDate: new Date(Date.now()),
    // setters
    setName(name) {
        this.name = name
    },
    setFirstName(firstName) {
        this.firstName = firstName
    },
    setBirthDate(date) {
        this.birthDate = date
    },
    // getters
    getName() {
        return this.name
    },
    getFirstName() {
        return this.firstName
    },
    getAge() {
        return this.birthDate
    },
    // methoden
    rename(firstName, name) {
        this.name = name;
        this.firstName = firstName;
    },
    changeTo(firstName, name, birthDate) {
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
    },
    print() {
        console.log(`name: ${this.name}\nfirst name: ${this.firstName}\ndate of birth: ${this.birthDate}`)
    },
};

person.print();
person.rename("Jochen", "Hansoul");
person.setBirthDate(new Date("1990-05-11"));
person.firstName = "Jan";
console.log(person.getFirstName());
person.print();

// prototypes - meestal gebruikt voor functions in objecten
let person2 = Object.create(person);
person2.changeTo("Bert", "VanderslagMulders", new Date("1970-01-15"));
person2.print();