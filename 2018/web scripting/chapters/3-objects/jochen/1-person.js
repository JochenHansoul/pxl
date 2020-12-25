'use strict';

// de naam : function() {} wordt blijkbaar niet meer gedaan

// object creation
let person1 = {
    _firstName: "jochen",
    _name: "Hansoul",
    _birthDate: new Date("1990-05-11"),
    // setters
    setFirstName : function(firstName) {
        this._firstName = firstName
    },
    setName : function(name) {
        this._name = name
    },
    setBirthDate : function(birthDate) {
        this._birthDate = birthDate
    },
    // getters
    getFirstName : function() { //lange notatie (short hand notatie beter)
        return this._firstName
    },
    getName : function() {
        return this._name
    },
    getBirthDate : function() {
        return this._birthDate
    },
    // methoden
    calculateAge : function () {
        return new Date(Date.now()).getFullYear() - this._birthDate.getFullYear()
    },
    print : function () {
        console.log(`first name: ${this._firstName}, name: ${this._name}, age: ${this.calculateAge()}`)
    }
};

// printing
person1.setName("Flack");
console.log(person1.getName());
console.log(person1.getBirthDate());
console.log(person1.calculateAge());
person1.print();