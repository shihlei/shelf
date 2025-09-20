/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function(fn, t) {
    // Tracks if we're in cooldown period
    let isThrottle = false;
    // Stores latest arguments during throttle period
    let nextArgs = null;

    return function(...args) {
        if(isThrottle){
            //wait - Store for later execution
            nextArgs = args;
        }
        else{
            fn(...args); // Execute immediately
            isThrottle = true; // Enter cooldown
            setTimeout(helper, t);
        }

        function helper(){
            // if there something schedule
            if(nextArgs){
                fn(...nextArgs);
                isThrottle = true;
                nextArgs = null;
                setTimeout(helper, t); // Schedule next cooldown period
            }
            else{
                // nothing scheduled yet - Exit throttle mode
                isThrottle = false;
            }
        }
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */