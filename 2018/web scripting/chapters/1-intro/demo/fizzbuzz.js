//zie ook https://eloquentjavascript.net/code/#2.2
// klik hier op "look at the solution"
for (let n = 1; n <= 100; n++) {
    let output = "";
    if (n % 3 == 0) {
        output += "Fizz";
    }
    if (n % 5 == 0) {
        output += "Buzz";
    }
    console.log(output || n);
}