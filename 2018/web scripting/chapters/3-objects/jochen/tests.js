'use strict';

const functArrow = () => {
    console.log("functArrow:");
    console.log(this);
    console.log(typeof this);
    //console.log(functArrow()) //only ends when trown exception (does not warn!)
};

function functionF() {
    console.log("functionF:");
    console.log(this);
    console.log(typeof this);
    //console.log(functionF()) //only ends wen thrown exception
}

class TestClass {
    constructor() {
        this.var1 = "testclass:"
    }
    testMethod() {
        console.log(this.var1);
        console.log(this);
        return () => {
            console.log("arrow method:");
            console.log(this);
            console.log(typeof this)
        }
    }
    testMethodF() {
        return function () {
            console.log("function method:");
            console.log(this);
            console.log(typeof this)
        }
    }
}


functArrow();

console.log("\n");
functionF();

console.log("\n");
let testObject = new TestClass();
let internalMethod = testObject.testMethod();
internalMethod();
let internalMethod2 = testObject.testMethodF();
internalMethod2();