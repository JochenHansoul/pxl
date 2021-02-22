'use strict';

// id's
const token = sessionStorage.getItem("mastermind token");
const idWaitingRoom = sessionStorage.getItem("mastermind waiting room id");
const idGameRoom = sessionStorage.getItem("mastermind game room id");
// links
const UrlLobbyNav = "http://localhost:63342/mastermind-frontend/lobby.html";
const UrlWaitingRoomNav = "http://localhost:63342/mastermind-frontend/waiting-room.html";
const UrlToGamePageNav = "http://localhost:63342/mastermind-frontend/game.html";
// nodes
const navLobby = document.getElementById("nav-lobby");
const navWaitingRoom = document.getElementById("nav-waiting-room");
const navGameRoom = document.getElementById("nav-game-room");

const goToPage = (id, url, name) => {
    if (id) {
        window.location.href = url
    } else {
        alert(`U moet eerst een ${name}`)
    }
};

// makes navigation ul li blue
if (token) {
    navLobby.classList.add("navigation-color-blue")
}

if (idWaitingRoom) {
    navWaitingRoom.classList.add("navigation-color-blue")
}

if (idGameRoom) {
    navGameRoom.classList.add("navigation-color-blue")
}


navLobby.addEventListener("click", function () {
    goToPage(token, UrlLobbyNav, "login doen")
});

navWaitingRoom.addEventListener("click", function () {
    goToPage(idWaitingRoom, UrlWaitingRoomNav, "waiting room aanmaken")
});

navGameRoom.addEventListener("click", function () {
    goToPage(idGameRoom, UrlToGamePageNav, "game aanmaken")
});