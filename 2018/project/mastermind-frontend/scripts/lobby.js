'use strict';

// IdGameRoom's
const IdWaitingRoomsRow = "waiting-room-row"; // these are for adding a CSS link
const IdWaitingRoomsGameName = "waiting-room-game-name";
// links
const UrlWaitingRooms = "https://localhost:44317/api/waitingrooms/";
const UrlWaitingRoomFrontEnd = "http://localhost:63342/mastermind-frontend/waiting-room.html";
// nodes
const NodeNameWaitingRoom = document.getElementById("name");
const NodeTableWaitingRooms = document.getElementById("waiting-rooms-body");
const NodeError = document.getElementById("error-message");
// buttons
const ButtonCreateWaitingRoom = document.getElementById("create-button");

// fields
let intervalWaitingRooms; // this variable is initialized in load block


const createNewWaitingRoom = () => {
    let name = NodeNameWaitingRoom.value;
    if (name.trim() !== "") {
        let waitingRoom = {
            name: name,
            gameSettings: {
                codeLength: 6,
                amountOfColors: 8,
                duplicateColorsAllowed: true,
                maximumAmountOfGuesses: 10,
                amountOfRounds: 1,
                mode: 1
            }};
        fetch(UrlWaitingRooms, {
            method: "POST",
            body: JSON.stringify(waitingRoom),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
            }
        })
            .then((response) => {
                if (response.status === 201) {
                    console.log(`Waiting room created code ${response.status}`);
                    return response.json();
                } else {
                    throw new Error(`Waiting room ${response.status}`)
                }
            })
            .then((response) => {
                sessionStorage.setItem("mastermind waiting room id", response.id);
                window.location.href = UrlWaitingRoomFrontEnd
            })
            .catch((e) => {
                NodeError.innerHTML = e
            })
    }
};

// checks if the user is already added to a waiting room or not
// (subfunction of createNewWaitingRoomIfNotAlreadyAdded and createAndAdTable)
const isNotAddedYet = (userId, waitingRooms) => {
    try { // created local error catching becouse non local didn't work
        if (!userId) throw new Error("You don't have and user IdGameRoom!");
        let isNotAdded = true;
        let numberWaitingRoom = 0;
        while (numberWaitingRoom < waitingRooms.length && isNotAdded) {
            let users = waitingRooms[numberWaitingRoom].users;
            for (let numberUser = 0; numberUser < users.length; numberUser++) {
                if (userId === users[numberUser].id) isNotAdded = false
            }
            numberWaitingRoom++
        }
        return isNotAdded
    } catch (e) {
        NodeError.innerHTML = e
    }
};

const createNewWaitingRoomIfNotAlreadyAdded = () => {
    let userId = sessionStorage.getItem("mastermind user id");
    fetch(UrlWaitingRooms, {
        method: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
        }
    })
        .then( (response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error(`with status ${response.status}`)
            }
        })
        .then((response) => {
            let isNotAdded = isNotAddedYet(userId, response);
            if (!isNotAdded) throw new Error("You are already added to a waiting room");
            createNewWaitingRoom()
        })
        .catch((e) => {
            NodeError.innerHTML = e;
        })
};

// Eventhandler for the waiting room table in HTML page: people can join a waiting room whey they click on it's name
const joinWaitingRoom = idWaitingRoom => {
    fetch(`${UrlWaitingRooms}${idWaitingRoom}/join`, {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
        }
    })
        .then((response) => {
            if (response.status === 200) {
                console.log(`Waiting room response: ${response.status}`);
            } else {
                throw new Error(`Waiting room ${response.status}`)
            }
        })
        .then(() => {
            sessionStorage.setItem("mastermind waiting room id", idWaitingRoom);
            window.location.href = UrlWaitingRoomFrontEnd
        })
        .catch((e) => {
            NodeError.innerHTML = e
        })
};

// adds waiting rooms to HTML page (subFunction of getWaitingRooms)
const createAndAdTable = waitingRooms => {
    NodeTableWaitingRooms.innerHTML = "";
    for (let i = 0; i < waitingRooms.length; i++) {
        let waitingRoom = waitingRooms[i];
        let roomData = [waitingRoom.name, `${waitingRoom.users.length}/${waitingRoom.maximumAmountOfUsers}`,
            waitingRoom.users];
        let tr = document.createElement("tr");
        for (let j = 0; j < roomData.length; j++) {
            let td = document.createElement("td");
            if (Array.isArray(roomData[j])) { // for adding users to the waiting room
                for (let k = 0; k < roomData[j].length; k++) {
                    td.appendChild(document.createTextNode(roomData[j][k].nickName));
                    if (k < roomData[j].length - 1) td.appendChild(document.createTextNode(", "))
                }
            } else {
                td.appendChild(document.createTextNode(roomData[j]));
            }
            tr.appendChild(td)
        }
        // add IdGameRoom's and event listener
        tr.id = IdWaitingRoomsRow;
        tr.firstChild.id = IdWaitingRoomsGameName;
        tr.firstChild.addEventListener("click", function () {
            // checks if the user is already added to this waiting room and if not ads the player
            let isNotAdded = isNotAddedYet(sessionStorage.getItem("mastermind user id"), waitingRooms);
            if (isNotAdded) {
                joinWaitingRoom(waitingRoom.id)
            } else {
                sessionStorage.setItem("mastermind waiting room id", waitingRoom.id);
                window.location.href = UrlWaitingRoomFrontEnd
            }
        });
        NodeTableWaitingRooms.appendChild(tr);
    }
};

// gets all the waiting rooms from the server, then adds them to the HTML page
const getWaitingRooms = () => {
    fetch(UrlWaitingRooms, {
        method: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
        }
    })
        .then( (response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error(`with status ${response.status}`)
            }
        })
        .then((response) => {
            createAndAdTable(response);
        })
        .catch((e) => {
            NodeError.innerHTML = e;
            clearInterval(intervalWaitingRooms) // stops ticking of error message
        })
};

const handleLoad = () => {
    try {
        getWaitingRooms();
        intervalWaitingRooms = setInterval(getWaitingRooms, 2000);
        ButtonCreateWaitingRoom.addEventListener("click", createNewWaitingRoomIfNotAlreadyAdded);
        NodeNameWaitingRoom.addEventListener("keydown", event => { // ads room when pressed enter on input field
            if (event.key === "Enter") {
                event.preventDefault();
                createNewWaitingRoomIfNotAlreadyAdded();
            }
        })
    } catch (e) {
        NodeError.innerHTML = e
    }
};

window.addEventListener("load", handleLoad);