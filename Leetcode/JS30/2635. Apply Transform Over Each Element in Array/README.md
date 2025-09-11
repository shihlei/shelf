## 2635. Apply Transform Over Each Element in Array

🔗 [Link](https://leetcode.com/problems/apply-transform-over-each-element-in-array/description/)

**📝 Topic: map(), callback**

Given an integer array arr and a mapping function fn, return a new array with a transformation applied to each element.

The returned array should be created such that returnedArray[i] = fn(arr[i], i).

Please solve it without the built-in Array.map method.

**Example 1:**

>Input: arr = [1,2,3], fn = function plusone(n) { return n + 1; }  
Output: [2,3,4]  
Explanation:  
const newArray = map(arr, plusone); // [2,3,4]  
The function increases each value in the array by one.   

**Example 2:**

> Input: arr = [1,2,3], fn = function plusI(n, i) { return n + i; }  
Output: [1,3,5]  
Explanation: The function increases each value by the index it resides in.  

**Example 3:**

>Input: arr = [10,20,30], fn = function constant() { return 42; }  
Output: [42,42,42]  
Explanation: The function always returns 42.


  ----

### Callback
- A callback is a function you pass as an argument to another function.
- Why Use Callbacks?
  - The simple answer is they allow you to write code that can be reused across different use-cases.
- Array.map
  - map is one example of using callbacks
  - is a higher-order (functional) method on Array.prototype: it takes a function and returns a new array of transformed values, without mutating the original.



### Implement
See the js code file

### Evaluate

n is the length of array

Time Complexity: O(n)

Space Complexity: O(n)
  
