// algemeen voorbeeld
let rabbit = {};
rabbit.saySomething = function (line) {
    console.log(`the rabbit says '${line}'`)
};
rabbit.saySomething("I am fine");
console.log("\n");


// method: this
const speak = function (line) {
    console.log(`the ${this.type2} ${this.type1} says '${line}'`)
};
let whiteRabbit = {type1: "rabbit", type2: "white", speak}; // de function speak word aan object whiteRabbit toegevoegd
whiteRabbit.speak("What time is it?");
speak.call(whiteRabbit, "burp");

let rabbit2 = {type1: "rabbit", speak};
speak.call(rabbit2, "hello, goodbye");

speak("I don't have a type");