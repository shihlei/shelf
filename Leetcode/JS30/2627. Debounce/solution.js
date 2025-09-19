/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let id;
    return function(...args) {
        // Cancel previous execution (when t have not passed yet) It can safe take undefined
        clearTimeout(id);

        // Schedule new execution
        id = setTimeout(() => fn(...args), t);
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */

 // debounce - delaying some execution, prevent some operation from happen many times