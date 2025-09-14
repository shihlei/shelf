/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    // solution that create a callback function
    function callback(resolve, reject){
        setTimeout(resolve, millis);
    }

    return new Promise(callback);

    // The same one line solution:
    return new Promise((resolve, reject) => {
        setTimeout(resolve, millis)
    })

    // returning a promise of undefined
    await new Promise((resolve, reject) => {
        setTimeout(resolve, millis)
    })
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */