"use strict";
// naam: Jochen Hansoul
import Product from './Product';
export default class Container{
    constructor(maxWeight) {
        if (typeof maxWeight != "number") {
            throw new Error("maxWeight must be a number")
        }
        if (maxWeight <= 0) {
            throw new Error("maxWeight must be greather then zero")
        }
        this._maxWeight = maxWeight;
        this._products = []
    }

    addProduct(product) {
        // forgot to add the !
        if (product instanceof Product) {
            throw new Error("product must be an instance of Product")
        }
        let id = product.id;
        let sum = 0;
        for (let singleProduct of this._products) {
            if (id === singleProduct.id) {
                throw new Error("product id already added")
            }
            sum += singleProduct.weight
        }
        sum += product.weight;
        if (sum > this._maxWeight) {
            throw new Error("Products exceed maxWeight")
        }
        this._products.push(product)
    }

    getProductAtIndex(index) {
        if (!Number.isInteger(index)) {
            throw new Error("index is not an integer");
        }
        if (index <= 0) {
            throw new Error("index must be greather ten zero")
        }
        if (index > this._products.length) {
            throw new Error("index can not be longer then the length of the array")
        }
        return this._products[index] // needed to be index -1
    }
}
