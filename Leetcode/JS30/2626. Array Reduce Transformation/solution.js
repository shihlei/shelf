/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    //return nums.reduce(fn,init);

    let res = init;

    for(let n of nums){// n is the value in array
        res = fn(res,n);
    }
    return res;
};
