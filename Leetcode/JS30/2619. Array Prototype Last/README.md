## 2619. Array Prototype Last

🔗 [Link](https://leetcode.com/problems/array-prototype-last/description/)

**📝 Topic: Array.prototype**

Write code that enhances all arrays such that you can call the array.last() method on any array and it will return the last element. If there are no elements in the array, it should return -1.

You may assume the array is the output of JSON.parse.


**Example 1:**

> Input: nums = [null, {}, 3]  
Output: 3  
Explanation: Calling nums.last() should return the last element: 3.  

**Example 2:**

> Input: nums = []  
Output: -1  
Explanation: Because there are no elements, return -1.  

----

### 💫 array.prototype()

- Array.prototype is the prototype object for all JavaScript arrays. It contains all the methods and properties that are available to every array instance.

- Array.prototype is a built-in object that serves as the blueprint for all arrays in JavaScript. When you create an array, it inherits methods and properties from Array.prototype through JavaScript's prototype chain.

Built-in methods: It contains all the standard array methods like:

> push(), pop(), shift(), unshift()  
map(), filter(), reduce(), forEach()  
slice(), splice(), concat()  
find(), indexOf(), includes()  
And many more  

Extensibility: You can add custom methods to all arrays by modifying Array.prototype:
```js
Array.prototype.last = function() {
  return this[this.length - 1];
};

const arr = [1, 2, 3];
console.log(arr.last()); // 3
```
