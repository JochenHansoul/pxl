'use strict';

// constants
const AmountOfSquares = 6;
const ColorsFeedBack = ["black", "white", "beige"];

// id game room
const IdGameRoom = sessionStorage.getItem("mastermind game room id");

// links
const UrlGameStatus = `https://localhost:44317/api/games/${IdGameRoom}/status`;
const UrlMakeGuess = `https://localhost:44317/api/games/${IdGameRoom}/guess`;
const UrlIsAbleToGuess = `https://localhost:44317/api/games/${IdGameRoom}/canguess/forround/`;
const UrlToLobbyPage = "http://localhost:63342/mastermind-frontend/lobby.html";

// nodes
const NodeWaitingOnPlayers = document.getElementById("waiting-on-players");
const NodeError = document.getElementById("error-message");
const DrawingCanvas = document.getElementById("canvas-mastermind");

// drawing context
const DrawingContext = DrawingCanvas.getContext("2d");

// buttons
const ButtonSendGuess = document.getElementById("button-send-guess");
const ButtonRemoveColor = document.getElementById("button-remove-color");
const ButtonsToAdColors = document.querySelectorAll(".button-color"); // this is an array of buttons


// fields
let roundNumber; // number of round starting from 0
let intervalWaitingForPlayers;
let ableToGuess;
let colorsGuessed; //inialiseert de code array
let unfinishedPlayers;

let coordinateJ; //coordinates for drawSquire function - I think it pushes the squares downwards
let FillX, FillY; //coordinaten voor de filler



const gameOver = status => {
    alert(status);
    window.location.href = UrlToLobbyPage
};

// checks if the game is over or not, and who the winner is - works but wrong result from back-end
const getStatusGame = () => {
    fetch(UrlGameStatus, {
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
                throw new Error(`status game: ${response.status}`);
            }
        })
        .then((response) => {
            console.log(`status game response roundnumber: ${response.currentRoundNumber}`);
            roundNumber = response.currentRoundNumber;
            /*if (response.gameOver) {
                gameOver(`Player ${response.finalWinner.nickName} has won`)
            }*/
        })
        .catch((e) => {
            NodeError.value = e;
        })
};

// add content to DrawingCanvas
const drawSquares = () => {
    //draws squares
    for (let i = 0; i < AmountOfSquares; i++) {
        DrawingContext.rect(30 + i * 60, coordinateJ, 50, 50);
    }
    // draws tiny squares
    for (let i = 0; i < Math.round(AmountOfSquares / 2); i++) {
        for (let j = 0; j < 2; j++) {
            DrawingContext.rect(AmountOfSquares * 70 + i * 25, coordinateJ + j * 25, 20, 20)
        }
    }
    DrawingContext.stroke()
};

const drawLittleSquares = result => {
    FillX = 30;
    FillY += 60;
    let counter = 0;
    for (let rows = 0; rows < Math.round(AmountOfSquares / 2); rows++) {    // tekent de kleine vakjes op het DrawingCanvas
        for (let columns = 0; columns < 2; columns++) {
            DrawingContext.fillStyle = result[counter];
            DrawingContext.fillRect(AmountOfSquares * 70 + rows * 25, coordinateJ + columns * 25, 20, 20);
            counter++
        }
    }
    coordinateJ += 60;
    drawSquares();
};

const processResultOfGuess = (correctColorAndPosition, correctColor) => {
    // for remembering the colors of the squares
    /*
    if (!sessionStorage.getItem("mastermind past guesses")) {
        sessionStorage.setItem("mastermind past guesses", colorsGuessed)
    } else {
        let pastGuesses = sessionStorage.getItem("mastermind past guesses");
        pastGuesses += colorsGuessed;
        sessionStorage.setItem("mastermind past guesses", pastGuesses);
    }
     */
    colorsGuessed = [];
    let result = [];
    let correctAndNotCorrect = [correctColorAndPosition, correctColor, AmountOfSquares - correctColorAndPosition - correctColor];
    for (let i = 0; i < ColorsFeedBack.length; i++) {
        for (let j = 0; j < correctAndNotCorrect[i]; j++) {
            result.push(ColorsFeedBack[i]);
        }
    }
    console.log(`game round: ${roundNumber}`);
    drawLittleSquares(result);
    getStatusGame()
};

const makeGuess = () => {
    if (ableToGuess) {
        if (colorsGuessed.length !== AmountOfSquares) {
            alert("Your guessed colors isn't finished");
        } else {
            //intervalWaitingForPlayers = setInterval(isAbleToGuess, 2000);
            let colors = {colors: colorsGuessed};
            fetch(UrlMakeGuess, {
                method: "POST",
                body: JSON.stringify(colors),
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
                }
            })
                .then((response) => {
                    if (response.status === 200) {
                        console.log(`make guess: ${response.status}`);
                        return response.json();
                    } else {
                        throw new Error(`make guess error status ${response.status}`);
                    }
                })
                .then((response) => {
                    processResultOfGuess(response.correctColorAndPositionAmount, response.correctColorAmount)
                })
                .catch((e) => {
                    NodeError.innerHTML = e
                });
        }
    } else {
        alert("u kunt geen guess maken")
    }
};

// processes if the player is able to make a guess or not or needs to wait
const processResponse = response => {
    if (response === 1) {
        ableToGuess = true;
    } else {
        ableToGuess = false;
        if (response  === 500) {
            NodeWaitingOnPlayers.innerHTML = `Waiting on ${unfinishedPlayers} player to make a guess...`;
        } else if (response === 501) {
            NodeWaitingOnPlayers.innerHTML = `Maximum guesses reached`;
            gameOver("maximum guesses reached. You have lost");
        } else if (response === 502) {
            NodeWaitingOnPlayers.innerHTML = `Round not yest started`;
        } else if (response === 503) {
            NodeWaitingOnPlayers.innerHTML = `Round has already started without you`;
        } else {
            NodeWaitingOnPlayers.innerHTML = `unknown waiting`
        }
    }
};

// asks the server if the player is able to make a guess - works but gives wrong results from back-end
const isAbleToGuess = () => {
    fetch(UrlIsAbleToGuess + roundNumber, { // roundnumber is for the current round
        method: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("mastermind token")
        }
    })
        .then((response) => {
            if (response.status === 200) {
                return response.json()
            }
        })
        .then((response) => {
            processResponse(response)
        })
        .catch((e) => {
            NodeError.value = e;
        })
};

// removes a color of a square
const removeGuess = () => {
    if (colorsGuessed.length > 0) {
        colorsGuessed.pop();
        FillX -= 60;
        DrawingContext.fillStyle = ColorsFeedBack[2];
        DrawingContext.fillRect(FillX, FillY, 50, 50);
    }
};

// color button ads a color to a square
const addColor = color => {
    if (colorsGuessed.length < AmountOfSquares) {
        colorsGuessed.push(color);
        DrawingContext.fillStyle = color;
        DrawingContext.fillRect(FillX, FillY, 50, 50);
        FillX += 60;
    }
};

const handleLoad = () => {
    try {
        // initialization game
        roundNumber = 0;
        colorsGuessed = [];
        unfinishedPlayers = 1;
        coordinateJ = 60; //coordinates for drawSquire function
        FillX = 30;
        FillY = 60;
        // set dimensions DrawingCanvas and draw squares
        DrawingCanvas.height = 1000 + 450;
        DrawingCanvas.width = AmountOfSquares * 80 + 70;
        // attempt to make past guesses reappear, works but only with little squaires
        /*
        if (sessionStorage.getItem("mastermind past guesses")) {
            let colors = sessionStorage.getItem("mastermind past guesses");
            let colorsArray = colors.split(',');
            let amountOfRounds = colorsArray.length / 6;
            for (let i = 0; i < amountOfRounds; i++) {
                let colorsSingleRound = [];
                for (let j = 6 * i; j < 6 * (i + 1); j++) {
                    colorsSingleRound.push(colorsArray[j]);
                }
                drawLittleSquares(colorsSingleRound)
            }
        }
         */
        drawSquares();

        // function for is able to guess
        isAbleToGuess();
        intervalWaitingForPlayers = setInterval(isAbleToGuess, 2000);

        // add eventListeners to buttons
        for (let i = 0; i < ButtonsToAdColors.length; i++)  { // ads a color to squares when clicked on button
            ButtonsToAdColors[i].addEventListener("click", function () {
                addColor(ButtonsToAdColors[i].value)
            })
        }
        ButtonRemoveColor.addEventListener("click", removeGuess);
        ButtonSendGuess.addEventListener("click", makeGuess);
    } catch (e) {
        NodeError.innerHTML = e
    }
};

window.addEventListener("load", handleLoad);