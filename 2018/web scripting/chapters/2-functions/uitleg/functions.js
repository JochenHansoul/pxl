/*
function
const met binding
const met pijltjesnotatie (vaak internet, weinig regels code)
 */

//function
console.log("function: " + square1(2));
function square1(x) {
    return x * x;
}

//binding
const square2 = function (x) { // constante
    return x * x;
};
console.log("binding " + square2(3)); // bij const moet de functie eerst aangemaakt worden! (heeft te maken met ISO standaarden)

//pijlnotatie
const square3 = (x) => {return x * x}; // Als je maar 1 parameter hebt mag haakjes weg. Bij 1 return statement mogen {} weg
console.log("pijlnotatie: " + square3(2) + "\n\n");



// binding, maar met let i.p.v. const
let safeMode = true;
let launchMissiles = function () {
    console.log("launching missiles")
}; // hierachter ; i.p.v. achter bewerking
if (safeMode) {
    launchMissiles = function () {
        console.log("nothing happens") // const kan niet wijzigen, als let wel wijzigen!
    };
}
launchMissiles();

// zonder parameters
const bark = () => {console.log("wafwaf");};
bark();

// meerdere parameters
const power = (base, exponent) => {
    let result = 1;
    for (let i = 0; i < exponent; i++) {
        result *= base;
    }
    return result;
};
console.log(power(2, 3));
console.log(power(2)); // exponent op undefined --> komt niet in de lus geeft 1

function minus(a, b) {
    if (b === undefined) {
        return -a;
    } else {
        return a - b;
    }
}
console.log(minus(2, 3));


function power1(base, exponent) {
    let result = 1;
    for (let i = 0; i < exponent; i++){
        result *= base;
    }
    return result;
}
console.log(power(1, 0));

function factorial(number) {
    if (number == 0) {
        return 1;
    }
    return number * factorial(number - 1); // deze functie roept zichzelf op!!!
}
console.log(factorial(5));