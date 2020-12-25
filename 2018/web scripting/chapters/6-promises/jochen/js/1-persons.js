'use strict';

const url = "http://localhost:3000/persons/";
const urlFriendsSeparate = "&id=";
const idSelect = "select-person";
const output = document.getElementById("output-person");
const outputSelect = document.getElementById("output-select");

const createSelect = () => {
    fetch(url)
        .then( (response) => {
            if (response.status === 200) { // status niet vergeten
                return response.json();
            }
            throw new Error(`with status ${response.status}`)
        })
        .then((persons) => {
            let select = document.createElement("select");
            select.id = idSelect;
            for (let person of persons) {
                let option = document.createElement("option");
                option.value = person.id;
                option.appendChild(document.createTextNode(person.name));
                select.appendChild(option)
            }
            outputSelect.appendChild(select)
        })
        .catch((e) => {
            output.appendChild(document.createTextNode(e))
        })
};

const createTable = (content) => {
    let table = document.createElement("table");
    for (let i = 0; i < content.length; i++) {
        let tr = document.createElement("tr");
        for (let j = 0; j < content[i].length; j++) {
            let td = document.createElement("td");
            td.appendChild(document.createTextNode(content[i][j]));
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    return table
};

const getAllPersons = () => {
    output.innerHTML = "";
    fetch(url)
        .then( (response) => {
            if (response.status === 200) { // status niet vergeten
                return response.json();
            } else {
                throw new Error(`with status ${response.status}`)
            }
        })
        .then((persons) => {
            let dataPersons = [];
            for (let person of persons) {
                dataPersons.push([person.id, person.name])
            }
            let table = createTable(dataPersons);
            output.appendChild(table)
        })
        .catch((e) => {
            output.appendChild(document.createTextNode(e))
        })
};

const getPersonById = id => {
    if (id.trim() !== "" && !(isNaN(id.trim()))) { // controleren of niet leeg is
        output.innerHTML = "";
        fetch(url + id)
            .then((response) => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    throw new Error(`with status ${response.status}`)
                }
            })
            .then((person) => {
                let dataPerson = [[person.id, person.name]];
                let table = createTable(dataPerson);
                output.appendChild(table)
            })
            .catch((e) => {
                output.appendChild(document.createTextNode(e))
            })
    }
};

const getPersonByName = name => {
    if (name.trim() !== "") { // controleren of niet leeg is
        output.innerHTML = "";
        fetch(url + "?name=" + name)
            .then((response) => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    throw new Error(`with status ${response.status}`)
                }
            })
            .then((personArray) => {
                let person = personArray[0];
                let dataPerson = [[person.id, person.name]];
                let table = createTable(dataPerson);
                output.appendChild(table)
            })
            .catch((e) => {
                output.appendChild(document.createTextNode(e))
            })
    }
};

const postPerson = name => {
    if (name !== "") {
        let person = {name: name, friends: []};
        fetch(url, {
            method: "POST",
            body: JSON.stringify(person),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
            .then((response) => {
                if (response.status === 201) {
                    return response.json();
                } else {
                    throw new Error(`with status ${response.status}`)
                }
            })
            .then((person) => {
                let dataPerson = [[person.id, person.name]];
                let table = createTable(dataPerson);
                output.appendChild(table)
            })
            .catch((e) => {
                output.appendChild(document.createTextNode(e))
            })
    }
};

const changePersonName = (id, name) => {
    if (id.trim() !== "" && name.trim() !== "") {
        output.innerHTML = "";
        let person = {name: name};
        fetch(url + id, {
            method: "PUT",
            body: JSON.stringify(person),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
            .then((response) => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    throw new Error(`with status ${response.status}`)
                }
            })
            .then((person) => {
                let dataPerson = [[person.id, person.name]];
                let table = createTable(dataPerson);
                output.appendChild(table)
            })
            .catch((e) => {
                output.appendChild(document.createTextNode(e))
            })
    }
};

const getFriends = (arrayFriends, name) => {
    let newUrl = url + "?id=" + arrayFriends[0];
    for (let i = 1; i < arrayFriends.length; i++) {
        newUrl += urlFriendsSeparate + arrayFriends[i];
    }
    fetch(newUrl)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error(`with status ${response.status}`)
            }
        })
        .then((persons) => {
            //console.log(persons);
            let outputString = `${name} heeft vrienden` ;
            for(let i = 0; i < persons.length - 1; i++) {
                outputString += ` ${persons[i].name},`;
            }
            outputString += ` ${persons[persons.length - 1].name}`;
            output.appendChild(document.createTextNode(outputString));
        })
        .catch((e) => {
            output.appendChild(document.createTextNode(e))
        })
};

const findFriends = () => {
    let id = document.getElementById(idSelect).value;
    if (id.trim() !== "") { // controleren of niet leeg is
        output.innerHTML = "";
        let name;
        let friends;
        fetch(url + id)
            .then((response) => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    throw new Error(`with status ${response.status}`)
                }
            })
            .then((person) => {
                name = person.name;
                let arrayFriends = person.friends;
                getFriends(arrayFriends, name)
            })
            .catch((e) => {
                output.appendChild(document.createTextNode(e))
            })
    }
};

const onLoad = () => {
    try {
        // creating a select field
        createSelect();
        // getting persons
        document.getElementById("button--get-all-persons").addEventListener("click", getAllPersons);
        document.getElementById("button--get-id-person").addEventListener("click", function () {
            getPersonById(document.getElementById("get-id-person").value)
        });
        document.getElementById("button--get-name-person").addEventListener("click", function () {
            getPersonByName(document.getElementById("get-name-person").value)
        });
        // posting persons
        document.getElementById("button--post-name-person").addEventListener("click", function () {
            postPerson(document.getElementById("post-name-person").value)
        });
        // changing person
        document.getElementById("button--change-name-person").addEventListener("click", function () {
            let id = document.getElementById("change-name-id-person").value;
            let name = document.getElementById("change-name-person").value;
            changePersonName(id, name)
        });
        // get friends
        document.getElementById("button--get-friends").addEventListener("click", findFriends)
    } catch (e) {
        console.log(e)
    }
};

window.addEventListener("load", onLoad);