'use strict';

let canvas = document.querySelector("canvas");
let context = canvas.getContext("2d"); // in welke context ge gaat tekeken
context.beginPath();

context.strokeStyle = "black";
context.lineWidth = 3;

context.moveTo(70, 30); // linksboven
context.lineTo(10, 100); // linksonder
context.lineTo(90, 100); // rechtsonder
context.lineTo(150, 30); // rechtsboven
// diagonale lijn
context.lineTo(70, 30);
context.lineTo(90, 100);

context.stroke();


/* huis tekenen */
let canvasHouse = document.body.getElementsByTagName("canvas")[1];
let ctx2 = canvasHouse.getContext("2d");

context.strokeStyle = "black";
ctx2.lineWidth = 3;

ctx2.moveTo(10, 50);
ctx2.lineTo(10, 150);
ctx2.lineTo(150, 150);
ctx2.lineTo(150, 50);
ctx2.lineTo(80, 15);
ctx2.lineTo(10, 50);
ctx2.lineTo(150, 50);

ctx2.stroke();