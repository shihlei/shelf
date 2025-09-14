## 2623. Memoize

🔗 [Link](https://leetcode.com/problems/curry/description/)

**📝 Topic: **

Given a function fn, return a curried version of that function.

A curried function is a function that accepts fewer or an equal number of parameters as the original function and returns either another curried function or the same value the original function would have returned.

In practical terms, if you called the original function like sum(1,2,3), you would call the curried version like csum(1)(2)(3), csum(1)(2,3), csum(1,2)(3), or csum(1,2,3). All these methods of calling the curried function should return the same value as the original.

**Example 1:**

> Input:  
fn = function sum(a, b, c) { return a + b + c; }  
inputs = [[1],[2],[3]]  
Output: 6  
Explanation:  
The code being executed is:  
const curriedSum = curry(fn);  
curriedSum(1)(2)(3) === 6;  
curriedSum(1)(2)(3) should return the same value as sum(1, 2, 3).  


---

### 💫 Currying

- A fundamental technique in **functional programming** that transforms how functions handle multiple arguments.
- currying transforms how we think about function parameters - instead of requiring all arguments at once, we can provide them incrementally and get back specialized functions along the way.

```js
const curriedSum = curry(sum);

// All these calls are equivalent and return 6:
curriedSum(1)(2)(3);        // Classic currying: one arg at a time
curriedSum(1, 2)(3);        // Partial application: multiple args at once
curriedSum(1)(2, 3);        // Mixed approach
curriedSum(1, 2, 3);        // All args at once (like original)
```
