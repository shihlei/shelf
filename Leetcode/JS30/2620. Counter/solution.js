var createCounter = function(n) {
    let current = n;
    return function() {
        return current++; //Hidden state
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */

/**
-> class solution: 

class counter {
    constructor(n){
        this.n=n;
    }

    //Method, function don't need the "function" keyword in class
    increase(){
        //++after will increase after return
        //++before will increase before return
        return this.n++;
    }
}

const counter = counter(10);
counter.increase();//10

 */
