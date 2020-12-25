'use strict';

const changeStyle = link => {
    //document.head.getElementsByTagName("link")[0].href = link;
    let paragraphes = document.body.getElementsByTagName("article")[0].getElementsByTagName("p");
    for (let paragraph of paragraphes) {
        paragraph.style.marginLeft = 150 + "px";
        paragraph.style.marginRight = 150 + "px";
        paragraph.style.textIndent = 20 + "px";
        paragraph.style.color = "#C9C892";
    }
    let header = document.body.getElementsByTagName("h1")[0];
    header.style.textAlign = "left";
    header.style.color = "#AAAA66";
};