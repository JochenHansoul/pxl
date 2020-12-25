'use strict';

// string is de tag
// returnt een array met al de noden in die O_MOUNTAINS die de tag naam hebben - vb. <span> tag in <h1> O_MOUNTAINS

const byTagName = (node, string) => {
    return node.getElementsByTagName(string)
};


console.log(byTagName(document.body, "span")); // vreemd genoeg kan hij ook geneste elementen vinden