'use strict';

let date = new Date();
console.log(date);
console.log(new Date(Date.now())); // hetzelfde
console.log(Date.now()); //epoch time
console.log("");

console.log(date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear());
// getDay() is dag van de week
// getMonth() starts at index 0


console.log(new Intl.DateTimeFormat('nl-BE').format(date));

//console.log(date.split("T"));

/*let datep = Date.prototype.toLocaleString();
console.log(datep); */