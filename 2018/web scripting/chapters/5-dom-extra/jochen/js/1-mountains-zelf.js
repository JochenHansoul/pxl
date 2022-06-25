'use strict';

const O_MOUNTAINS = document.getElementById("mountains");

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

/*
Made by Hansoul Jochen on 20/03/2019 at Universal University PXL
Content requires a nested array made op of al the rows of the table
*/

// files with .mjs extension for javascript modules
// exporteren lukt niet met gewone .js files
/*
exports.createTable = (rowsHead, rowsBody, rowsFoot, ...content) => {
    let table = document.createElement("table");
    // table head
    if (rowsHead > 0) {
        table.appendChild(document.createElement("thead"));
        for (let i = 0; i < rowsHead; i++) {
            table.firstChild.appendChild(document.createElement("tr"));
            let row = content[i];
            for (let j = 0; j < row.length; j++) { // rijen invoeren
                // table, thead, tr (i), th (j)
                table.firstChild.childNodes[i].appendChild(document.createElement("th"));
                table.firstChild.childNodes[i].childNodes[j].appendChild(document.createTextNode(row[j]))
            }
        }
    }
    // table body
    if (rowsBody > 0 && (rowsHead > 0 || rowsFoot > 0)) {
        table.appendChild(document.createElement("tbody"));
        for (let i = 0; i < rowsBody; i++) {
            table.childNodes[rowsHead > 0 ? 1 : 0].appendChild(document.createElement("tr"));
            let row = content[ i + rowsHead];
            let tableBody = rowsHead > 0 ? 1 : 0;
            for (let j = 0; j < row.length; j++) { // rijen invoeren
                // table, tbody (0/1), tr (i), td (j)
                table.childNodes[tableBody].childNodes[i].appendChild(document.createElement("td"));
                table.childNodes[tableBody].childNodes[i].childNodes[j].
                appendChild(document.createTextNode(row[j]))
            }
        }
    } else {
        for (let i = 0; i < rowsBody; i++) {
            table.appendChild(document.createElement("tr"));
            let row = content[ i + rowsHead];
            for (let j = 0; j < row.length; j++) { // rijen invoeren
                table.childNodes[i].appendChild(document.createElement("td"));
                table.childNodes[i].childNodes[j].appendChild(document.createTextNode(row[j]))
            }
        }
    }
    // table foot
    if (rowsFoot > 0) {
        table.appendChild(document.createElement("tfoot"));
        for (let i = 0; i < rowsFoot; i++) {
            table.lastChild.appendChild(document.createElement("tr"));
            let row = content[ i + rowsHead + rowsBody];
            for (let j = 0; j < row.length; j++) { // rijen invoeren
                // table, tfoor (last), tr (i), td (j)
                table.lastChild.childNodes[i].appendChild(document.createElement("td"));
                table.lastChild.childNodes[i].childNodes[j].appendChild(document.createTextNode(row[j]))
            }
        }
    }
    return table
};
*/

/*
// voorbeeld scriptje
//import {createTable} from './create_table'; // werkt niet bij browser
//const TextModule = require('./create_table');
let tableBody = ["name body", "height body", "place body"];
let tableFoot = ["name foot", "height foot", "place foot"];
let table1 = createTable(2, 2, 2, ...[tableHead, tableHead, tableBody, tableBody, tableFoot, tableFoot]);
document.body.appendChild(table1);
*/



// new way, made on Wednesday 5 June 2019 at home
// adjusted on 5 and 6 March 2020

// idea 3 April 2020
// is it better to just let the subfunctions out of the main createTable function
// or is it better practise to include the subfunctions inside their respectife function
// so that they cannot be used by anything else and it is obvious in which function they belong.
// maybe use a lot of large input and measure the time between each of them to see how it works

// subFunction of createTablePart
const createTableRow = (dataPart, subPart) => {
    let tableRow = document.createElement("tr");
    for (let data of dataPart) {
        let tableData = document.createElement(subPart);
        tableData.appendChild(document.createTextNode(data));
        tableRow.appendChild(tableData)
    }
    return tableRow
};

// createTablePart is a subFunction used by createTable
const createTablePart = (dataPart, namePart, subPart) => {
    let tablePart = document.createElement(namePart);
    // checks if the array is nested. If not --> creates a single row, if it is --> creates multiple rows
    if (Array.isArray(dataPart) && !Array.isArray(dataPart[0])) {
        tablePart.appendChild(createTableRow(dataPart, subPart));
    } else {
        for (let row of dataPart) {
            tablePart.appendChild(createTableRow(row, subPart))
        }
    }
    return tablePart
};

// input of creataTable must either be an empty array
// (if no values are presented),
// an array (for a single row) or a nested array (for multiple rows)
/*
    better idea:
    function createTable ( {}, table = document.createElement("table")) { return table }
    input object:
    {
        tableHead: []
        tableBody: [],
        tableFoot: []
    }
    All properties are array that contain the data that goes into each part.
    When the property does not excist or is undefined that part is not created.
    If only the tableBody excist then only a table with content is created and
    even if only an empty array is geven then this table part is created. this
    was an user can easily choose to add a table head, body or foot or not by
    simply including the properties of the object.
    The table object can be used if you allready have a table and simply want
    to add things to id or if it's a bit table to immediately add rows and
    columns to the front end. It can also just be used to simply create a
    table body or other table part and add the data simply as the body. this
    way one function can be used to create tables with multiple parts or a
    single table part!
*/
const createTable = (body, head = [], foot = []) => {
    let table = document.createElement("table");
    // table body
    if (body) {
        if (head.length || foot.length) { //checks if head or body is not an empty array
            table.appendChild(createTablePart(body, "tbody", "td"))
        } else {
            return createTablePart(body, "table", "td");
        }
    }
    if (head) {
        table.prepend(createTablePart(head, "thead", "th"));
    }
    if (foot) {
        table.appendChild(createTablePart(foot, "tfoot", "td"));
    }
    return table
};


// I was comparing the time between two different functions but it was useless
//let date1 = new Date();
O_MOUNTAINS.appendChild(createTable(MOUNTAINS, TABLE_HEAD));
//let date2 = new Date();
//console.log(date2.getMilliseconds() - date1.getMilliseconds());
