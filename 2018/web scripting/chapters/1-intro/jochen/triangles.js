// parameters
let aantalLijnen = 7;
let symbool = "#";

// 1.a
console.log("1.a nr 2::");
for (let i = 1; i <= aantalLijnen; i++){
    console.log(symbool.repeat(i));
}

// 1.a alternatief
console.log("\n1.a nr 3:");
for (let line = "#"; line.length <= aantalLijnen; line += "#") {
    console.log(line);
}

// 1.b
console.log("\n1.b nr 2:");
for (let i = 1; i <= aantalLijnen; i++) {
    console.log(" ".repeat(aantalLijnen - i) + symbool.repeat(i));
}

// 1.c
console.log("\n1.c nr2:");
for (let i = 1; i <= aantalLijnen; i++) {
    console.log(" ".repeat(aantalLijnen - i) + symbool.repeat(1 + (i - 1) * 2));
}

// 1.d
console.log("\n1.d:");
let symboolTwee = "@";
let teller = 4;
let aantalSymbolen = 1; // begin 1, dan 3, dan 5...
for (let i = 1; i <= aantalLijnen; i++) {
    let uitvoer = "";
    // spaties
    for (let j = aantalLijnen - i; j > 0; j--) {
        uitvoer += " ";
    }
    // symbolen
    for (let j = 0; j < aantalSymbolen; j++) {
        if (teller == 4) {
            uitvoer += symboolTwee;
            teller = 0;
        }  else {
            uitvoer += symbool;
            teller++;
        }
    }
    console.log(uitvoer);
    aantalSymbolen += 2;
}


console.log("\n1.d nr 2:");
//let symboolTwee = "@";
count = 0; // voor bepalen of symbool of symboolTwee
for (let i = 1; i <= aantalLijnen; i++) {
    let output = "";
    for (let j = 1; j <= 1 + (i - 1) * 2; j++) {
        output += count % 5 === 0 ? symboolTwee : symbool; // true: eerste; false: tweede
        count++;
    }
    console.log(" ".repeat(aantalLijnen - i) + output);
}



// zonder repeat:

// 1.a
/*console.log("1.a:");for (let i = 1; i <= aantalLijnen; i++) {
    let uitvoer = "";
    for (let j = 1; j <= i; j++) {
        uitvoer += symbool;
    }
    console.log(uitvoer);
}
console.log("");*/

// 1.b
/*console.log("1.b:");
for (let i = 1; i <= aantalLijnen; i++) {
    let uitvoer = "";
    // spaties
    for (let j = aantalLijnen - i; j > 0; j--) {
        uitvoer = uitvoer + " ";
    }
    // symbolen
    for (let j = 0; j < i ; j++) {
        uitvoer += symbool;
    }
    console.log(uitvoer);
}*/

// 1.c
/*console.log("1.c:");
for (let i = 1; i <= aantalLijnen; i++) {
    let uitvoer = "";
    // spaties
    for (let j = aantalLijnen - i; j > 0; j--) {
        uitvoer += " ";
    }
    uitvoer += symbool;
    // symbolen
    if (i != 1) {
        for (let j = 0; j < i - 1 ; j++) {
            uitvoer += symbool + symbool;
        }
    }
    console.log(uitvoer);
}*/