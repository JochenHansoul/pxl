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
