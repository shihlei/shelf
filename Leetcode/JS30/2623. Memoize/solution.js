/**
 * @param {Function} fn
 */
function memoize(fn) {
    const cache = {};//a.k.a hashmap

    return function(...args) {
        // Convert arguments(object) to string key
        const key = JSON.stringify(args);

        // check if already in cache
        if(key in cache){
            return cache[key];// Return cached result
        }

        cache[key] = fn(...args); // Call original function and Cache the result
        return cache[key];
    }
}

// Decorator Design pattern


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
