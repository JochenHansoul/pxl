"use strict";

import Container from './cargo/Container.js';
import Product from './cargo/Product.js';

try {
    const product1 = new Product(1, 200);
    const product2 = new Product(2, 100);
    const product3 = new Product(3, 401);
    const container = new Container(700);

    container.addProduct(product1);
    container.addProduct(product2);
    console.log(container.getProductAtIndex(1).weight);
    container.addProduct(product3);
} catch (error) {
    console.log(error.message);
}
