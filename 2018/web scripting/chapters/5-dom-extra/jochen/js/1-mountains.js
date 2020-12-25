'use strict';

const C_MOUNTAIN = "mountain-height";
const TABLE_HEAD = ["last_name", "height", "place"];
const MOUNTAINS = [
    {name: "Kilimanjaro", height: 5895, place: "Tanzania"},
    {name: "Everest", height: 8848, place: "Nepal"},
    {name: "Mount Fuji", height: 3776, place: "Japan"},
    {name: "Vaalserberg", height: 323, place: "Netherlands"},
    {name: "Denali", height: 6168, place: "United States"},
    {name: "Popocatepetl", height: 5465, place: "Mexico"},
    {name: "Mont Blanc", height: 4808, place: "Italy/France"}
];

const E_MOUNTAINS = document.getElementById("mountains");

const createTableMountains = (head, body) => {
    let table = document.createElement("table");
    // table head
    let thead = document.createElement("thead");
    let tr = document.createElement("tr");
    for (let data of head) {
        let th = document.createElement("th");
        th.appendChild(document.createTextNode(data));
        tr.appendChild(th)
    }
    thead.appendChild(tr);
    table.appendChild(thead);
    // table body
    let tableBody = document.createElement("tbody");
    for (let mountain of body) {
        let tr = document.createElement("tr");
        for (let key of Object.keys(mountain)) {
            let td = document.createElement("td");
            td.appendChild(document.createTextNode(mountain[key]));
            if (key === "height") td.classList.add(C_MOUNTAIN); // adding class
            tr.appendChild(td);
        }
        tableBody.appendChild(tr)
    }
    table.appendChild(tableBody);
    return table
};

try {
    E_MOUNTAINS.appendChild(createTableMountains(TABLE_HEAD, MOUNTAINS));
} catch (e) {
    console.log(e)
}


/*
let table = document.createElement("table");
// adding table head
table.appendChild(document.createElement("tr"));
for (let i = 0; i < tableHead.length; i++) {
    table.childNodes[0].appendChild(document.createElement("th"));
    table.firstChild.childNodes[i].appendChild(document.createTextNode(tableHead[i]))
}
// adding table body
for (let i = 0; i < mountains.length; i++)  {
    let tRow = i + 1;
    table.appendChild(document.createElement("tr"));
    for (let j = 0; j < table.firstChild.childNodes.length; j++) {
        table.childNodes[tRow].appendChild(document.createElement("td"));
    }
    let secondTd = table.childNodes[tRow].childNodes[1];
    secondTd.className = "mountain-height";
    table.childNodes[tRow].childNodes[0].appendChild(document.createTextNode(mountains[i].name));
    table.childNodes[tRow].childNodes[1].appendChild(document.createTextNode(mountains[i].height));
    table.childNodes[tRow].childNodes[2].appendChild(document.createTextNode(mountains[i].place));
}

let bodyNode = document.getElementById("mountains");
bodyNode.appendChild(table);
*/