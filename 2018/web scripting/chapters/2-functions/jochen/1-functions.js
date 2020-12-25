'use strict';

/*const minimum = (getal1, getal2) => {
    if (getal1 < getal2) {
        return getal2;
    } else if (getal1 === getal2) {
        return "gelijk"; // string gelijk was niet de bedoeling
    } else {
        return getal1;
    }
};*/
const minimum = (n1, n2) => n1 < n2 ? n1 : n2;


const minimumReeks = function(...getallen) {
    // if getallen.length() === 0 return undefined
    let kleinsteGetal = 1e1000; // beter Infinity, kan ook gewoon getallen[0]
    for (let getal of getallen) {
        if (getal < kleinsteGetal) {
            kleinsteGetal = getal;
        }
    }
    return kleinsteGetal
};


// model oplossing 1.b
const minimum2 = function(...nummers) {
    let minimum = Infinity; // Infinity omdat het het grootste getal is
    for (let nummer of nummers) {
        minimum = minimum <= nummer ? minimum : nummer; // minimum <= nummer --> minimum else nummer
    }
    return minimum
};

// het is misschien beter te werken met alleen if's en als laatste gewoon return isEven
const isEven = getal => {
    if (getal === 0) { // je kan beter 3 = gebruiken dan gaat hij ook naar het type kijken, zij heeft gewoonte om altijd 3 = te gebruiken
        return true;
    } else if (getal === 1) {
        return false;
    } else {
        return isEven(getal - 2);
    }
};


console.log("1.a:");
console.log(minimum(2, 3));

console.log("\n1.b:");
console.log(minimumReeks(5, 7, 2));

console.log("\n2:");
console.log(isEven(5));