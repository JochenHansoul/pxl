'use strict';
class InputError extends Error{}

class Vec {
    constructor(x, y) {
        if (isNaN(x) || isNaN(y)) throw new InputError("x or y is not a number");
        this._x = x;
        this._y = y;
    }
    // setters
    set x(x) {
        if (isNaN(x)) throw new InputError("x or y is not a number");
        this._x = x
    }
    set y(y) {
        if (isNaN(y)) throw new InputError("x or y is not a number");
        this._y = y
    }
    // getters
    get x() {
        return this._x
    }
    get y() {
        return this._y
    }
    // methoden
    plus(vec2) {
        if (!(vec2 instanceof Vec)) throw new InputError("not a type of Vec");
        return new Vec(this._x + vec2.x, this._y + vec2.y)
    }

    minus(vec2) {
        if (!(vec2 instanceof Vec)) throw new InputError("not a type of Vec");
        return new Vec(this._x - vec2.x, this._y - vec2.y)
    }

    length(vec2) {
        if (!(vec2 instanceof Vec)) throw new InputError("not a type of Vec");
        return Math.sqrt(Math.pow(this._x - vec2.x, 2) + Math.pow(this._y - vec2.y, 2))
    }

    print() {
        console.log(`x:${this._x} y:${this._y}`)
    }

    toString() {
        return `(${this._x},${this._y})`
    }
}


class PolyLine{
    constructor() {
        this._vecs = [];
    }
    // methods
    addVec(vec) {
        if (!(vec instanceof Vec)) throw new InputError("not type of Vec");
        this._vecs.push(vec)
    }
    toString() {
        let output = "";
        for (let vec of this._vecs) {
            output += vec; //dit lijkt automatisch vec.toString() te doen
        }
        return output
    }
}


try {
    let polyLine1 = new PolyLine();
    polyLine1.addVec(new Vec(1, 1));
    polyLine1.addVec(new Vec(2, 2));
    polyLine1.addVec(new Vec(3, 3));

    console.log("polyline: " + polyLine1.toString());
} catch (e) {
    if (e instanceof InputError) console.log(`Input ${e}`)
}



/*console.log("testing slice:");
let arrayList = [];
arrayList.push(1);
arrayList.push(2);
arrayList.push(3);
console.log(arrayList);
console.log(arrayList.slice(0, arrayList.length));*/

console.log("\n\n");


// vec objects
let vec1 = new Vec(1, 1);
console.log(typeof vec1);
if (vec1 instanceof Vec) { // voor negatief: (!(...))
    console.log("is \"an instance\" of Vec")
} else {
    console.log("is not instance of Vec");
}

// number variables
let number1 = 1;
console.log(typeof number1);
if (typeof number1 == 'number') {
    console.log("type of number")
} else {
    console.log("not type of number")
}

// strings
let newString = "";
console.log(typeof newString);
if (typeof newString == 'string') {
    console.log("type of string")
} else {
    console.log("not type of string")
}