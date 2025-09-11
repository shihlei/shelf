## 2634. Filter Elements from Array

🔗 [Link](https://leetcode.com/problems/filter-elements-from-array/description/)

**📝 Topic: filter(), callback**

Given an integer array arr and a filtering function fn, return a filtered array filteredArr.

The fn function takes one or two arguments:

- arr[i] - number from the arr
- i - index of arr[i]

filteredArr should only contain the elements from the arr for which the expression fn(arr[i], i) evaluates to a truthy value. A truthy value is a value where Boolean(value) returns true.

Please solve it without the built-in Array.filter method.

**Example 1:**

> Input: arr = [0,10,20,30], fn = function greaterThan10(n) { return n > 10; }  
Output: [20,30]  
Explanation:  
const newArray = filter(arr, fn); // [20, 30]  
The function filters out values that are not greater than 10  

**Example 2:**

> Input: arr = [1,2,3], fn = function firstIndex(n, i) { return i === 0; }  
Output: [1]  
Explanation:  
fn can also accept the index of each element  
In this case, the function removes elements not at index 0  

**Example 3:**

> Input: arr = [-2,-1,0,1,2], fn = function plusOne(n) { return n + 1 }  
Output: [-2,0,1,2]  
Explanation:  
Falsey values such as 0 should be filtered out  

---

### Fundamental programming

**Declarative Programming**

What you want to achieve - you describe the desired outcome without specifying the exact steps.

Example:
```js
javascriptreturn arr.filter(fn);
```

- You're declaring "I want a filtered array based on this function"
- You don't specify HOW the filtering happens (looping, checking conditions, etc.)
- The .filter() method handles all the implementation details
- More readable and concise
- Less prone to bugs since you're not managing the iteration logic

**Imperative Programming**

How to achieve it - you specify the exact steps and control flow.

Example:
```js
javascriptconst result = [];
for(let i=0; i<arr.length; i++){
    if(fn(arr[i], i)){
        result.push(arr[i]);
    }
}
return result;
```
- You're explicitly stating each step: create array, loop, check condition, push if true
- You control the iteration, condition checking, and result building

### Implement
See the js code file

