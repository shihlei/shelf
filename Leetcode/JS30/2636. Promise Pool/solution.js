/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Promise<any>}
 */
var promisePool = async function(functions, n) {
    // Shared counter across all workers
    let i =0;

    // Worker function - each instance processes functions sequentially
    async function callback(){
        while (i < functions.length) {
            await functions[i++]();
        }
    }

    // Create n concurrent workers
    const nPromise = Array(n).fill().map(callback);

    // Wait for all workers to complete
    await Promise.all(nPromise);
    // promise 1 -> promise 2 -> promise 3
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */