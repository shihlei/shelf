/**
 * @return {Function}
 */
// Function Syntax : create a variavle and assign with a function. And return with a function
const createHelloWorld = function() {
    return function(...args) {
        return "Hello World";
    }
};
