'use strict';

// url's
const UrlRegister = "https://localhost:44317/api/authentication/register"; // for registering user
const UrlAuthenticationToken = "https://localhost:44317/api/authentication/token"; // for logging in
const UrlLobby = "http://localhost:63342/mastermind-frontend/lobby.html"; // for going to lobby page after logging in
// nodes
const NodeNickName = document.getElementById("nickname");
const NodeEmail = document.getElementById("email");
const NodePassword = document.getElementById("password");
const NodeError = document.getElementById("error-message");
// buttons
const ButtonSubmit = document.getElementById("submit-button");


/*
correct e-mails:
12345678@student.pxl.be
voornaam.naam@student.pxl.be
*/

/*
password needs to contain:
lowercase, uppercase, number and symbol ($,%,#)
*/

const checkNickname = (nickname) => {
    try {
        if (!nickname) throw new Error("Must contain nickname");
        return true
    } catch (e) {
        NodeError.innerHTML += e + "\n"
    }
};

const checkEmail = (email) => {
    try {
        if (!email) throw new Error("No input value with e-mail");
        if (!email.includes("@")) throw new Error("Email does not contain '@'");
        let emailArray = email.split("@");
        if (emailArray.length > 2) throw new Error("Email may only contain one '@'");
        if (emailArray[1] !== "student.pxl.be") throw new Error("Email suffix must be @student.pxl.be");
        // checking prefix
        let emailPrefix = emailArray[0];
        if (emailPrefix.includes(".")) {
            let firstAndLastName = emailPrefix.split(".");
            if (firstAndLastName.length > 2) throw new Error("Email prefix may not contain more than 1 point");
            return true
        } else if (emailPrefix.length === 8 && !isNaN(emailPrefix)) {
            return true
        }
        throw new Error("Email prefix must either be 'firstname.name' or '01234567'")
    } catch (e) {
        NodeError.innerHTML += e + "\n"
    }
};

const checkPassword = (password) => {
    try {
        let noLower = true, noUpper = true, noSymbol = true, noNumber = true;
        if (password.length < 6) throw new Error("Password need to consist of 6 characters");
        for (let i = 0; i < password.length; i++) {
            let character = password.charAt(i);
            if (isNaN(character)) {
                if (character === character.toLocaleLowerCase()) noLower = false;
                if (character === character.toUpperCase()) noUpper = false;
                if (character === "$" || character === "%" || character === "#") noSymbol = false;
            } else {
                noNumber = false;
            }
        }
        if (noLower) throw new Error("Password must contain a lower key");
        if (noUpper) throw new Error("Password must contain an upper key");
        if (noSymbol) throw new Error("Password must contain a symbol");
        if (noNumber) throw new Error("Password must contain a number");
        return true
    } catch (e) {
        NodeError.innerHTML += e + "\n"
    }
};

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
            sessionStorage.setItem("mastermind token", response.token); // javascript kent dit gewoon niet
            sessionStorage.setItem("mastermind user id", response.player.id);
            window.location.href = UrlLobby
        })
        .catch((e) => {
            NodeError.innerHTML = e
        });
};

const registerPerson = (nickname, email, password) => {
    let person = {email: email, password: password, nickName: nickname};
    fetch(UrlRegister, {
        method: "POST",
        body: JSON.stringify(person),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
        .then((response) => {
            if (response.status === 200) {
                console.log(`You are registered with status: ${response.status}`);
                loginUser(email, password)
            } else {
                throw new Error(`error with status: ${response.status}`);
            }
        })
        .catch((e) => {
            NodeError.innerHTML = e;
        })
};

const checkAndRegisterPerson = () => {
    NodeError.innerHTML = "";
    let nickname = NodeNickName.value;
    let email = NodeEmail.value;
    let password = NodePassword.value;
    let nicknameCorrect = checkNickname(nickname);
    let emailCorrect = checkEmail(email);
    let passwordCorrect = checkPassword(password);
    if (nicknameCorrect && emailCorrect && passwordCorrect) registerPerson(nickname, email, password);
};

const handleLoad = () => {
    try {
        ButtonSubmit.addEventListener("click", checkAndRegisterPerson)
    } catch (e) {
        NodeError.innerHTML = e
    }
};

window.addEventListener("load", handleLoad);