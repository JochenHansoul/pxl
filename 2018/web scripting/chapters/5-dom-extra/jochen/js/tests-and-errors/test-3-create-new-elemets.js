'use strict';

let article = document.getElementsByTagName("article")[0];
let newNode = document.createElement("h1");
newNode.appendChild(document.createTextNode("titel"));
console.log(article.firstChild);
article.removeChild(article.firstChild);
//article.replaceChild(newNode, article.firstChild);