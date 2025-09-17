var TimeLimitedCache = function() {
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const alreadyExits = this.cache.get(key);
    if(alreadyExits){
        //clear timeout
        clearTimeout(alreadyExits.timeoutId);
    }

    //remove the expire key
    const timeoutID = setTimeout(() => {
        this.cache.delete(key);
    }, duration);

    // Set new entry
    this.cache.set(key, {value, timeoutId: timeoutID});

    return Boolean(alreadyExits);
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    if(this.cache.has(key)){
         return this.cache.get(key).value;
    }
    return -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return this.cache.size;
};


/////////////////////////

// Class solution
class TimeLimitedCache{
    cache = new Map();

    set = function(key, value, duration) {
        const alreadyExits = this.cache.get(key);
        if(alreadyExits){
            //clear timeout
            clearTimeout(alreadyExits.timeoutId);
        }

        const timeoutID = setTimeout(() => {
            //remove the expire key
            this.cache.delete(key);
        }, duration);

        this.cache.set(key, {value, timeoutId: timeoutID});

        return Boolean(alreadyExits);
    };

    get = function(key) {
        if(this.cache.has(key)){
            return this.cache.get(key).value;
        }
        return -1;
    };

    count = function() {
        return this.cache.size;
    };
}


/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */