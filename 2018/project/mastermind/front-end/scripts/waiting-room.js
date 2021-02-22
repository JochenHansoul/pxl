'use strict';

// IdGameRoom's
const IdWaitingRoom = sessionStorage.getItem("mastermind waiting room id");
// links
const UrlWaitingRoom = `https://localhost:44317/api/waitingrooms/${IdWaitingRoom}`;
const UrlLeaveWaitingRoom = `https://localhost:44317/api/WaitingRooms/${IdWaitingRoom}/leave`;
const UrlStartGame = `https://localhost:44317/api/games?waitingRoomId=${IdWaitingRoom}`; // for starting game
const UrlToLobby = "http://localhost:63342/mastermind-frontend/lobby.html";
const UrlToGamePage = "http://localhost:63342/mastermind-frontend/game.html";
// nodes
const NodeRoomId = document.getElementById("room-id");
const NodeRoomUsers = document.getElementById("room-users");
const NodeUserAmount = document.getElementById("user-amount");
const NodeError = document.getElementById("error-message");
// buttons
const ButtonStart = document.getElementById("start-button");
const ButtonLeave = document.getElementById("leave-button");


// fields
let intervalWaitingRoom; //Om de seconde wordt er gerefreshed


//Outputvakken worden ingevuld met de opgehaalde values
const loadWaitingRoom = waitingRoom => {
    NodeRoomId.innerHTML = waitingRoom.name;
    NodeUserAmount.innerHTML = `${waitingRoom.users.length}/${waitingRoom.maximumAmountOfUsers} players`;
    //NodeRoomUsers.innerHTML = "<b>Players:</b> <br><br>";
    let boldNode = document.createElement("b");
    boldNode.appendChild(document.createTextNode("Players:"));
    NodeRoomUsers.innerHTML = ""; // clears node
    NodeRoomUsers.appendChild(boldNode);
    NodeRoomUsers.appendChild(document.createElement("br"));
    NodeRoomUsers.appendChild(document.createElement("br"));
    let counter = 0;
    waitingRoom.users.forEach((user) => {
        counter++;
        NodeRoomUsers.innerHTML += `${counter}) ${user.nickName}<br>`
    })
};

//Fetch request om de waiting room op de halen
const getAndLoadWaitingRoom =() => {
    fetch(UrlWaitingRoom, {
        method: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
        }
    })
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error(`Waiting room ${response.status}`);
            }
        })
        .then((response) => {
            console.log(`load waitingroom data: ${response}`);
            loadWaitingRoom(response);
            if(response.gameHasStarted){ // automatically starts game when it has started
                sessionStorage.setItem("mastermind game room id", response.gameId);
                window.location.href = UrlToGamePage;
            } else if (response.users.length === response.maximumAmountOfUsers) {
                startNewGame() // starts game when user amount is 4
            }
        })
        .catch((e) => {
            NodeError.value = e;
        })
};

const startNewGame = () => {
    fetch(UrlStartGame, {
        method: "POST",
        //body: JSON.stringify(IdWaitingRoom),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
        }
    })
        .then((response) => {
            if(response.status === 201) {
                return response.json();
            } else {
                throw new Error("Failed to start game, please try again.");
            }
        })
        .then((response) => {
            sessionStorage.setItem("mastermind game room id", response.id);
            window.location.href = UrlToGamePage;
        })
        .catch((e) => {
            NodeError.innerHTML = e;
        })
};

const leaveWaitingRoom = () => {
    fetch(UrlLeaveWaitingRoom, {
        method: "POST",
        body: JSON.stringify(IdWaitingRoom),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
        }
    })
        .then((response) => {
            if (response.status === 200) {
                sessionStorage.removeItem("mastermind waiting room id");
                window.location.href = UrlToLobby;
            } else {
                throw new Error(`Can't leave waitingroom: ${response.status}, please try again.`)
            }
        })
        .catch((e) => {
            NodeError.value = e;
        })
};


// waits until the HTML page is fully loaded before adding event listeners
const handleLoad = () => {
    getAndLoadWaitingRoom();
    ButtonStart.addEventListener("click", startNewGame);
    ButtonLeave.addEventListener("click", leaveWaitingRoom);
    intervalWaitingRoom = setInterval(getAndLoadWaitingRoom, 2000); //Om de seconde wordt er gerefreshed
};

window.addEventListener("load", handleLoad);