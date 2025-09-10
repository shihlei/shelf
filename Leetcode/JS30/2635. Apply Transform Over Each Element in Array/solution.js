/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    //return arr.map(fn); map is method of array object. map accept function as parameter

    const res = [];

    //"in" is to get index ("of" is to get value from array)
    for(const i in arr){ 
        res.push(fn(arr[i], Number(i))); // i is a string
    }

    return res;
};
