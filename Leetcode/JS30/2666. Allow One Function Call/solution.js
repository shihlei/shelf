var once = function(fn) {
    // Closure
    let called = false;

    // Inner function has access to 'called'
    return function(...args){
        if (called){
            return undefined;
        }

        called = true;// mark the function called once
        return fn.apply(this, args);
        
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */