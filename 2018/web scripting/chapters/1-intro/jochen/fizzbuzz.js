// 2
console.log("2:");
/*for (let i = 1; i <= 100; i++) {
    if (i % 5 == 0) {
        if (i % 3 != 0) {
            console.log("Buzz");
        } else {
            console.log("FizzBuzz");
        }
    } else if (i % 3 == 0) {
        console.log("Fizz");
    } else {
        console.log(i)
    }
}*/

// zij heeft het gedaan zonder te nesten: output += Fizz; output +="Buzz" in if's onder elkaar te doen! en console.log(output || number);
for (let i = 1; i <= 100; i++) {
    let output = "";
    if (i % 3 === 0) {
        output += "Fizz";
    }
    if (i % 5 === 0) {
        output += "Buzz";
    }
    console.log(output || i);
}

// 3
console.log("\n3:"); // veel te omslagtig
let symbool = "#";
for (let i = 0; i < 8; i++) {
    uitvoer = "";
    for (let j = 0; j < 8; j++) {
        if ((i + j) % 2 === 0) {
            uitvoer += symbool;
        } else {
            uitvoer += " ";
        }
    }
    console.log(uitvoer);
}

/*let grootte = 8;
let line = "";
for (let row = 0; row < grootte; row++) {
    if (row % 2 == 0) {

    }
    // nog iets
}*/

// 4
console.log("\n4:");
let bovengrens = 1;
let ondergrens = 100;
let som = 0;
for (x = bovengrens; x < ondergrens; x++) {
    if (x % 3 === 0) {
        som += x;
    }
}
console.log(som);

/*som = 0;
while (number % 3 != 0) {
    number += 1;
}
for (let iter = number; iter <= ondergrens; iter += 3) {

}
*/