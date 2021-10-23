"use strict";

let o = {
  key1: "val1",
  key2: "val2"
}

o["toString"] = function() {
  return this.key1 + " " + this.key2;
}

console.log(o.toString());
