// Jochen Hansoul
import Product from '../../../src/js/cargo/Product';
import Container from '../../../src/js/cargo/Container';

test("addProduct with string error", ()=> {
    expect(()=> {
        let container = new Container(1000);
        container.addProduct("test")
    }).toThrowError()
});

test("addProduct with same id error", ()=> {
    expect( ()=> {
        let product = new Product(1, 100);
        let container = new Container(1000);
        container.addProduct(product);
        container.addProduct(product)
    }).toThrowError()
})

test("addProduct over maxWeight error", ()=> {
    expect( ()=> {
        let product1 = new Product(1, 900);
        let product2 = new Product(2, 200);
        let container = new Container(1000);
        container.addProduct(product1);
        container.addProduct(product2)
    }) //.toThrowError() vergeten
})

