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
