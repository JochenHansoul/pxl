'use strict';
class InputError extends Error {}

class Vec {
    constructor(x, y) {
        if (isNaN(x) || isNaN(y)) throw new InputError("x or y is not a number"); // typeof y !== 'number')
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
        return `x:${this._x} y:${this._y}`
    }
}


try {
    let vec1 = new Vec(0, 0);
    let vec2 = new Vec(1, 1);

    let vec3 = vec1.plus(vec2);
    vec3.print();

    let vec4 = vec1.minus(vec2);
    vec4.print();

    console.log(vec1.toString());
    console.log(vec1.length(vec2));
} catch (e) {
    if (e instanceof InputError) console.log(`Input ${e}`)
}