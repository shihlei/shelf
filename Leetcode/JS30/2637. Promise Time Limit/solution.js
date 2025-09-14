/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    
    return async function(...args) {
        // Return promise
        return new Promise(async (resolve, reject) => {
            // callback
            const id = setTimeout(() => reject("Time Limit Exceeded"), t); // first var of setTimeout only accept function

            fn(...args)
                .then((res) => resolve(res))
                .catch((err) => reject(err))
                .finally(() => clearTimeout(id));

            // Async/Await + Clearing Timeout
            try{
                const res = await fn(...args);
                resolve(res);
            }catch(err){
                reject(err);
            }

            clearTimeout(id);

        })
    }
};

function fn(t){
    return new Promise(res => setTimeout(res,t));
}
// set time limit to 100ms
const limited = timeLimit(fn, 100);

limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
