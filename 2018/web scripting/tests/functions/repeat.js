const readline = require("readline")
let prompts = readline.createInterface(process.stdin, process.stdout)
prompts.question("Please enter a number", function(n) {
    console.log(n)
    process.exit()
})

let s = "s"
//let number = readline("Please enter a number")
//console.log(number)
s = s.repeat(5)
console.log(s)
