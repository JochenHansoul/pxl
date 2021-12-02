const childOne = document.getElementById("child-one");

const childOneHandler = () => {
    console.log('Captured on child one')
}

const childOneHandlerCatch = () => {
    console.log('Captured on child one in capture phase')
}

childOne.addEventListener("click", childOneHandler); 
childOne.addEventListener("click", childOneHandlerCatch, true); 
