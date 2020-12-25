// naam: Jochen Hansoul
'use strict';

const idSelectCountry = "select_country";
const divSelect = document.getElementById("div_select");
const divOutput = document.getElementById("div_output");
const buttonGetShips = document.getElementById("get_ships");

const removeAllChildren = node => {
    while (node.firstChild) { // of .hasChildNodes()
        node.firstChild.remove() // misschien nog sneller .removeChild()
    }
};

const handleGetShips = (countryId) => {
    removeAllChildren(divOutput);
    let url = 'http://localhost:3000/ship/';
    fetch(url + "?country_id=" + countryId)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error(`with status ${response.status}`)
            }
        })
        .then((ships) => {
            let ul = document.createElement("ul");
            let fastestSpeed = 0;
            let fastestShips = [];
            for (let i = 0; i < ships.length; i++) {
                let li = document.createElement("li");
                li.appendChild(document.createTextNode(`${ships[i].id}, ${ships[i].name}`));
                if (ships[i].speed >= fastestSpeed) {
                    if (ships[i].speed > fastestSpeed) {
                        fastestShips = []; // dit moest ik hier nog aan toevoegen
                        fastestSpeed = ships[i].speed;
                    }
                    fastestShips.push(i);
                }
                ul.appendChild(li)
            }
            for (let fastest of fastestShips) {
                ul.childNodes[fastest].style = "color:red"
            }
            divOutput.appendChild(ul)
        })
        .catch((e) => {
            divOutput.appendChild(document.createTextNode(e))
        })

};

const addEventListenerShipButton = () => {
    buttonGetShips.addEventListener("click", function () {
        let countryId = document.getElementById(idSelectCountry).value;
        handleGetShips(countryId);
    })
};

const addCountrys = () => {
    let url = 'http://localhost:3000/country/';
    fetch(url)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error(`with status ${response.status}`)
            }
        })
        .then((countries) => {
            for (let countrie of countries) {
                let option = document.createElement("option");
                option.value = countrie.id;
                option.appendChild(document.createTextNode(countrie.name));
                divSelect.firstChild.appendChild(option)
            }
            addEventListenerShipButton()
        })
        .catch((e) => {
            divOutput.appendChild(document.createTextNode(e))
        });
};

const handleWindowload = () => {
    try {
        let select = document.createElement("select");
        select.id = idSelectCountry;
        divSelect.appendChild(select);
        addCountrys();
    } catch (e) {
        divOutput.appendChild(document.createTextNode(e))
    }
};

window.addEventListener("load", handleWindowload);