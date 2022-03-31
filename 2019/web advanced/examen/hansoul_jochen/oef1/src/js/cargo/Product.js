"use strict";
// Jochen Hansoul
export default class Product {
    constructor(id, weight) {
        if (!Number.isInteger(id)) {
            throw new Error("id is not an integer");
        }
        if (id <= 0) {
            throw new Error("id must be greather ten zero")
        }
        if (typeof weight != "number") {
            throw new Error("Weight must be a number")
        }
        if (weight <= 0) {
            throw new Error("Weight must be greather then zero")
        }
        this._id = id;
        this._weight = weight;
    }

    get id() {
        return this._id;
    }

    get weight() {
        return this._weight;
    }

    set id(value) {
        this._id = value;
    }

    set weight(value) {
        this._weight = value;
    }
}
