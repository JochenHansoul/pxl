'use strict';

// links
const UrlAuthenticationToken = "https://localhost:44317/api/authentication/token";
const UrlLobby = "http://localhost:63342/mastermind-frontend/lobby.html";
// nodes
const NodeError = document.getElementById("error-message");
// buttons
const ButtonLogin = document.getElementById("login-button");


const loginUser = (email, password) => {
    let person = {email: email, password: password};
    fetch(UrlAuthenticationToken, {
        method: "POST",
        body: JSON.stringify(person),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
        .then((response) => {
            if (response.status === 200) {
                console.log(`Logged in ${response.status}`);
                return response.json(); // only for generating token
            } else {
                throw new Error(`error with status ${response.status}`);
            }
        })
        .then((response) => {
            sessionStorage.setItem("mastermind token", response.token);
            sessionStorage.setItem("mastermind user id", response.player.id);
            window.location.href = UrlLobby
        })
        .catch((e) => {
            NodeError.innerHTML = e
        });
};

const login = () => {
    let email = document.getElementById("email").value;
    if (!email) throw new Error("No email given");
    let password = document.getElementById("password").value;
    if (!password) throw new Error("No password given");
    loginUser(email, password)
};

const onLoad = () => {
    try {
        ButtonLogin.addEventListener("click", login);
    } catch (e) {
        NodeError.innerHTML = e
    }
};

window.addEventListener("load", onLoad);