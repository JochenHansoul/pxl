'use strict';


// elementen aanmaken
let header = document.createElement("h1");
header.appendChild(document.createTextNode("Titel of article"));
let paragraph = document.createElement("p");
paragraph.appendChild(document.createTextNode("a paragraph"));
// toevoegen aan artiekel
let article = document.createElement("article");
article.appendChild(header);
article.appendChild(paragraph);
document.body.appendChild(article);


/*
Allemaal manier om de body O_MOUNTAINS te vinden:
let documentBody = document.getElementsByTagName("body")[0];
let bodyNode = document.getElementById("body");
let bodyTag = document.body;
 */