// eerst een demo object maken
// misschien beter de shorthand methodenaam gebruiken
let person = {
    _name : "Tim", // _ voor op private te zetten
    _age : 22,
    print : function () {
        console.log(`naam: ${this._name} leeftijd: ${this._age}`); // backticks alt gr + pond
    },
    setName : function (name) {
        this._name = name;
    },
    getName : function () {
        return _name;
    }
};

person.print();
person.setName("Lisa");
person.print();

//let person = {name, age, print};
//person.print();