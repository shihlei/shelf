/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {

    //IMPERATIVE solution
	return function(x) {
        // functions.reverse() -> create a copy of function in reverse order
        for(const fn of functions.reverse()){
            x = fn(x); // accumulating the result in x variable
        }
        return x;
    }

    // functional programming 
    /*
    return function(x){
        const fn = (acc, f) => f(acc);
        return functions.reduceRight(fn, x);
    }
    */
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
