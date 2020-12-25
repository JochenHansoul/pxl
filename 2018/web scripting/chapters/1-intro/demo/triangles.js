//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/repeat


let aantalLijnen = 4;

// #
// ##
// ###
// ####
for (let i=1; i < aantalLijnen+1; i++){
    console.log("#".repeat(i));
}

//    #
//   ##
//  ###
// ####
for (let i=1; i < aantalLijnen+1; i++){
    console.log(	" ".repeat(aantalLijnen-i) +
        "#".repeat(i) );
}

//    #
//   ###
//  #####
// #######

for (let i=1; i < aantalLijnen+1; i++){
    console.log(" ".repeat(aantalLijnen-i) +
        "#".repeat(1+2*(i-1)) );
}
//    @
//   ###
//  #@###
// #@####@
let count=0;
for (let i=1; i < aantalLijnen+1; i++){
    let output="";
    for (j=0; j < 1+2*(i-1); j++){
        output += count % 5 == 0 ?"@":"#";
        count++;
    }
    console.log(" ".repeat(aantalLijnen-i) +
        output);
}