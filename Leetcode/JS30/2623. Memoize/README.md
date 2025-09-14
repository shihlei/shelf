## 2623. Memoize

🔗 [Link](https://leetcode.com/problems/memoize/)

**📝 Topic: Memoization(caching)**

Given a function fn, return a memoized version of that function.

A memoized function is a function that will never be called twice with the same inputs. Instead it will return a cached value.

You can assume there are 3 possible input functions: sum, fib, and factorial.

- sum accepts two integers a and b and returns a + b. Assume that if a value has already been cached for the arguments (b, a) where a != b, it cannot be used for the arguments (a, b). For example, if the arguments are (3, 2) and (2, 3), two separate calls should be made.
- fib accepts a single integer n and returns 1 if n <= 1 or fib(n - 1) + fib(n - 2) otherwise.
- factorial accepts a single integer n and returns 1 if n <= 1 or factorial(n - 1) * n otherwise.

**Example 1:**

> Input:  
fnName = "sum"  
actions = ["call","call","getCallCount","call","getCallCount"]  
values = [[2,2],[2,2],[],[1,2],[]]  
Output: [4,4,1,3,2]  
Explanation:  
const sum = (a, b) => a + b;  
const memoizedSum = memoize(sum);  
memoizedSum(2, 2); // "call" - returns 4. sum() was called as (2, 2) was not seen before.  
memoizedSum(2, 2); // "call" - returns 4. However sum() was not called because the same inputs were seen before.  
// "getCallCount" - total call count: 1  
memoizedSum(1, 2); // "call" - returns 3. sum() was called as (1, 2) was not seen before.  
// "getCallCount" - total call count: 2  

---

### 💫 Memoization

Memoization is an optimization technique where you cache the results of expensive function calls and return the cached result when the same inputs occur again.


### 💫 Function Decoration Pattern
```js
// Original function behavior + caching behavior = decorated function
const decoratedFunction = memoize(originalFunction);
```
- Takes a function → Returns an enhanced function
- Preserves the original interface (same parameters, same return type)
- Adds new behavior (caching) without modifying original behavior (calculation)
