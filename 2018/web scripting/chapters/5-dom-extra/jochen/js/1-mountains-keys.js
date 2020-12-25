'use strict';

let tableHead = ["last_name", "height", "place"];
let mountains = [
    {name: "Kilimanjaro", height: 5895, place: "Tanzania"},
    {name: "Everest", height: 8848, place: "Nepal"},
    {name: "Mount Fuji", height: 3776, place: "Japan"},
    {name: "Vaalserberg", height: 323, place: "Netherlands"},
    {name: "Denali", height: 6168, place: "United States"},
    {name: "Popocatepetl", height: 5465, place: "Mexico"},
    {name: "Mont Blanc", height: 4808, place: "Italy/France"}
];

let firstMountain = mountains[0]; // take first object
let keys = Object.keys(firstMountain);
console.log(keys); // [ 'name', 'height', 'place' ]
for (let key of keys) {
    console.log(firstMountain[key]);
}

console.log(firstMountain[keys]); // undefined