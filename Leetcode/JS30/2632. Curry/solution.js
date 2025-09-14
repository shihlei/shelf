/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function(fn) {
    let nums = [];
    
    return function curried(...args) {
        //closures (to remember arguments)
        nums = [...nums, ...args];

        // If we have enough arguments, call the original function
        if(fn.length === nums.length){
            const res = fn(...nums);
            nums = [];// reset
            return res
        }
        // Otherwise, return a new function that collects more arguments
        else{
            return curried;
        }
    }


    // recursive soltion
    return function curried(...args){
        if(fn.length === args.length){
            return fn(...args);
        }
        else{
            return function(...newArgs){
                return curried(...args, ...newArgs);
            }       
        }
    }
};


function sum(a, b) { return a + b; }
const csum = curry(sum);
csum(1)(2) // 3
 