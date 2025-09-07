## 2620. Counter

🔗 [Link](https://leetcode.com/problems/counter/description/)

**📝 Topic: Closures**

Given an integer n, return a counter function. This counter function initially returns n and then returns 1 more than the previous value every subsequent time it is called (n, n + 1, n + 2, etc).

**Example 1:**

> Input: 
n = 10  
["call","call","call"]  
Output: [10,11,12]  
Explanation:   
counter() = 10 // The first time counter() is called, it returns n.   
counter() = 11 // Returns 1 more than the previous time.  
counter() = 12 // Returns 1 more than the previous time.  

**Example 2:**
> Input:  
n = -2  
["call","call","call","call","call"]  
Output: [-2,-1,0,1,2]  
Explanation: counter() initially returns -2. Then increases after each sebsequent call.  


### Implement
See the js code file


### 💫 JavaScript Function Closures
A closure is a function plus the variables from its surrounding scope. The inner function can still read or update those variables after the outer function has returned. Variables are captured by reference, so their latest value is seen on each call.

**How it applies here**
```js
var createCounter = function(n) {
  let current = n;            // private state
  return function() {
    return current++;         // return then increment
  };
};
```

1. createCounter(n) creates current and returns a function that closes over it.
2. Each call reads current, returns it, then increments it.
3. The state lives across calls and is not accessible from the outside.

**Sequence**

If n = 5, calls return: 5, 6, 7, ....

**Common tweaks**

Start at n + 1: use return ++current.

Resettable counter: return an object with methods that share the same current.


### Evaluate

Time Complexity: O(1)

Space Complexity: O(1)
