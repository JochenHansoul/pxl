'use strict';
const TextModule = require('./modules/text.js');


let result = TextModule.uppercase('test');
console.log(result);
console.log(TextModule.alphabet);
console.log(TextModule.plus(4, 5));
console.log(TextModule.complicatedSum(1, 2, 3, 4));