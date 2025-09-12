/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */

// Approach 1: Closure
// Outer function is like a constructor
var createCounter = function(init) {
    // init and count are the hidden state that can be access
    // init is a parameter of the constructor method. Parameters only exist within the scope of that specific method
    let count = init;

    function increment(){
        return ++count;
    }

    const reset = () => {
        count = init;
        return count;
    }

    const decrement = () => {
        return --count;
    }

    // return object(mappings from strings to other value) to expose values
    return{
        increment:increment,
        reset:reset,
        decrement:decrement
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */



//Approach 2: Class
class createCounter{
    constructor(init){
        this.init = init; // init will out of scope
        this.count= init;
    }

    // Don't need "function" keyword for function in class
    increment(){
        return ++this.count;
    }

    decrement = () => {
        return --this.count;
    }

    reset = () => {
        this.count = this.init;
        return this.count;
    }
}

/**
 * const counter = new createCounter(5);
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
