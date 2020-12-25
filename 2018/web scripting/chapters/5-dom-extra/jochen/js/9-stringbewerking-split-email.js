'use strict';

// input fields
const I_EMAIL = document.getElementById("email");
// output fields
const O_ARRAY = [
    document.getElementById("first-name"),
    document.getElementById("last-name"),
    document.getElementById("email-domain"),
    document.getElementById("email-sub-domain")
];
const O_ERROR = document.getElementById("error-message");
// buttons
const B_SPLIT = document.getElementById("button-split");


const removeAllChildren = element => {
    while (element.firstChild) { // or: .hasChildNodes()
        element.firstChild.remove() // or maybe faster: .removeChild()
    }
};
const removeAllChildrenOfArray = elements => {
    for (let element of elements) {
        removeAllChildren(element)
    }
};


//made on 2020-03-17 by Jochen Hansoul
//verifies that the email-address is in the format of: firstname.lastname@subdomain.domain

const splitEmail = emailString => {
    // splits the email address in two and that there is only one "@" symbol
    if (!emailString) throw "Please fill in email";
    let splitInTwo = emailString.split("@");
    if (splitInTwo.length < 2) throw new Error("No \"@\" in the address");
    if (splitInTwo.length > 2) throw new Error("email may not contain more that two \"@\" symbols");
    // first part contains one "."
    let firstTwo = splitInTwo[0].split(".");
    if (firstTwo.length < 2) throw new Error("first part does not contain a \".\"");
    if (firstTwo.length > 2) throw new Error("first part may only contain one \".\"");
    // second part part contains "."
    let lastTwo = splitInTwo[1].split(".");
    if (lastTwo.length < 2) throw new Error("second part does not contain a \".\"");
    if (lastTwo.length > 2) throw new Error("second part may only contain one \".\"");
    return firstTwo.concat(lastTwo);
};


B_SPLIT.addEventListener("click", () => {
    // clearing output
    removeAllChildrenOfArray(O_ARRAY);
    removeAllChildren(O_ERROR);
    try {
        let emailArray = splitEmail(I_EMAIL.value);
        for (let i = 0; i < O_ARRAY.length; i++) {
            O_ARRAY[i].appendChild(document.createTextNode(emailArray[i]))
        }
    } catch (e) {
        O_ERROR.appendChild(document.createTextNode(e))
    }
});


/*
document.getElementById("first-name");
document.getElementById("last-name");
document.getElementById("email-domain");
document.getElementById("email-sub-domain");
 */


/*
//Made by Hansoul Jochen
//On 24 March 2019
//final version Friday 5 april 2019
const splitEmail = (emailString, outputFirstName, outputName, outputSubDomain, outputDomain, outputError) => {
    let outputNodes = [outputFirstName, outputName, outputSubDomain, outputDomain];
    try {
        // verification input
        if (!emailString) throw "No input value with e-mail";
        let firstDot = emailString.indexOf(".");
        let secondDot = emailString.indexOf(".", firstDot + 1);
        let thirdDot = emailString.indexOf(".", secondDot + 1);
        let firstAt = emailString.indexOf("@");
        let secondAt = emailString.indexOf("@", firstAt + 1);
        if (!(firstDot < firstAt && firstAt < secondDot && secondAt == -1 && thirdDot == -1)) {
            throw "Email adress needs to be in format: name.lastname@subdomein.domein";
        }
        // cutting email
        let placeHolder = emailString.split("@")[0].split(".");
        let emailArray = placeHolder.concat(emailString.split("@")[1].split("."));
        // output
        for (let i = 0; i < outputNodes.length; i++) {
            outputNodes[i].innerHTML = emailArray[i];
        }
        if (outputError) outputError.innerHTML = "";
    } catch (e) {
        for (let i = 0; i < outputNodes.length; i++) { // resets te velden
            outputNodes[i].innerHTML = ""
        }
        if (outputError) {
            outputError.innerHTML = e
        } else {
            console.log(e)
        }
    }
};
*/


/*
earlier attempts with classes (I didn't know that getElementById() can't be placed in a parent, only document)
nodesEmail[0].firstChild.nodeValue = firstName;
nodesEmail[1].firstChild.nodeValue = name;
nodesEmail[2].firstChild.nodeValue = subDomain;
nodesEmail[3].firstChild.nodeValue = domain;
*/

/*
second attempt now with id's:
document.getElementById(ids[0]).firstChild.nodeValue = name;
document.getElementById(ids[1]).firstChild.nodeValue = firstName;
document.getElementById(ids[2]).firstChild.nodeValue = domein;
document.getElementById(ids[3]).firstChild.nodeValue = subDomein;
*/

/*
third attempt after perfecting it with loop:
with this one you need to have a " " inside the output element
document.getElementById(ids[i]).firstChild.nodeValue = emailArray[i];
this one just continues to ad textnodes to the output element
document.getElementById(ids[i]).append(document.createTextNode(emailArray[i]))
 */

/*
fifth attempt
const clearContent = nodes => {
    for (let i = 0; i < nodes.length; i++) {
        nodes[i].innerHTML = ""
    }
};

const errorMessage = (O_MOUNTAINS, string) => {
    if (O_MOUNTAINS) {
        O_MOUNTAINS.innerHTML = string
    }
};

const splitEmail = (emailString, nodeFirstName, nodeName, nodeSubDomain, nodeDomain, nodeError) => {
    let nodes = [nodeFirstName, nodeName, nodeSubDomain, nodeDomain];
    if (emailString) {
        let firstDot = emailString.indexOf(".");
        let secondDot = emailString.indexOf(".", firstDot + 1);
        let thirdDot = emailString.indexOf(".", secondDot + 1);
        let firstAt = emailString.indexOf("@");
        let secondAt = emailString.indexOf("@", firstAt + 1);
        if (firstDot < firstAt && firstAt < secondDot && secondAt == -1 && thirdDot == -1) {
            let placeHolder = emailString.split("@")[0].split(".");
            let emailArray = placeHolder.concat(emailString.split("@")[1].split("."));
            for (let i = 0; i < nodes.length; i++) {
                nodes[i].innerHTML = emailArray[i];
            }
            errorMessage(nodeError, "")
        } else {
            clearContent(nodes);
            errorMessage(nodeError, "email adress needs to be in format: name.lastname@subdomein.domein")
        }
    } else {
        clearContent(nodes);
        errorMessage(nodeError, "No input value")
    }
};*/