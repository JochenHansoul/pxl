"use strict";

Object.defineProperty(String.prototype, 'hashCode', {
    value: function() {
        let hash = 0, i, chr;
        for (i = 0; i < this.length; i++) {
            chr   = this.charCodeAt(i);
            hash  = ((hash << 5) - hash) + chr;
            hash |= 0; // Convert to 32bit integer
        }
        return hash;
    }
});

let password = "pxl";
let hashedPassword = password.hashCode();
console.log(hashedPassword);