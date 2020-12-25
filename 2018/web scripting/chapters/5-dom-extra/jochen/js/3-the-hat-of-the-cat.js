'use strict';

/*
functie animate (time, previousTime)
functie newTime?
requestAnimationFrame is een methode
 */

// deze moeten op voorhand en buiten de functie bepaald worden:
let cat = document.querySelector( "img" );
let hat = document.getElementsByTagName("img")[1];
let hatNode = document.body.childNodes[1].firstChild; // deze werkt niet omdat het een O_MOUNTAINS is denk ik en het moet een element zijn
console.log(hat.nodeType);
console.log(hatNode.nodeType);
let angle = Math.PI / 2;

/*
In principe wordt functie animate oneindig keer opgeroepen
tijd wordt steeds verhoogd
hierdoor wordt angle bepaald (gaat ook steeds omhoog)
sin en cos worden via angle bepaald (gaan van -1 tot 1)
aan de hand daarvan worden bottom en right veranderd (kan de afstand wijzigen door * 10) + "px" achteraan
*/
const animate = ( time, previousTime ) => { // eerste keer uitgevoerd: time op een bepaalde manier bepaald, previousTime = undefined
    //console.log(time - previousTime); // meestal ergens rond de 16
    if( previousTime != null ) { // eerste keer niet gewijzigd
        angle += ( time - previousTime ) * 0.001; // de hoek veranderen - in haakjes kan gewoon "16" geplaatst worden
    }
    cat.style.top = ( Math.sin( angle ) * 20 ) + "px"; // sin: verticale verandering (gaan van -1 tot 1)
    cat.style.left = ( Math.cos( angle ) * 200 ) + "px"; // cos: horizontale verandering
    hat.style.top = ( Math.sin( angle ) * 20 ) + "px";
    hat.style.left = ( Math.cos( angle ) * 200 ) + "px";
    window.requestAnimationFrame( newTime => {return animate( newTime, time )} ); // reqAnimFr opnieuw aangeroepen, hoe werkt newTume?
};

window.requestAnimationFrame( animate );