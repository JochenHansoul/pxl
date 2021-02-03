// var wel geleerd maar mag niet gebruiken, ook niet op examen

// tot 2015 ecma standaard
// één van redenen dat wij geen var gebruiken!

console.log(a); // undefined, hij gaat helemaal naar beneden en haalt het
var a = 1;
console.log(a);

//console.log(b); // hier gaat hij naar beneden vind let maar mag deze niet ophalen -> error
let b = 1;
console.log(b);

let x = 10;
if (true) {
    let y = 10;
    var z = 30;
    console.log(x + y + z);
}
console.log(x + z); // als de var z in zet kan deze wel in de cointained if maar niet aan de contained y!
                    // moet weten als later in werkomgeving tegenkomt


const generateMultiplier = function (factor) {
    return function (number) { //(moet geen naam hebben blijkbaar) hij returnt letterlijk deze functie! --> het getal word dan ingevoerd in deze functie
        return number * factor
    };
};
console.log("zonder een getal:" + generateMultiplier(2));

const twice = generateMultiplier(2); // twice want factor 2
console.log(twice(6));
const threeTimes = generateMultiplier(3);
console.log(threeTimes(6));
