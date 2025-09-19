## 2627. Debounce

🔗 [Link](https://leetcode.com/problems/debounce/description/)

**📝 Topic: debounce**

Given a function fn and a time in milliseconds t, return a debounced version of that function.

A debounced function is a function whose execution is delayed by t milliseconds and whose execution is cancelled if it is called again within that window of time. The debounced function should also receive the passed parameters.

For example, let's say t = 50ms, and the function was called at 30ms, 60ms, and 100ms.

The first 2 function calls would be cancelled, and the 3rd function call would be executed at 150ms.

If instead t = 35ms, The 1st call would be cancelled, the 2nd would be executed at 95ms, and the 3rd would be executed at 135ms.

**Example 1:**

> Input:  
t = 50  
calls = [  
  {"t": 50, inputs: [1]},  
  {"t": 75, inputs: [2]}  
]  
Output: [{"t": 125, inputs: [2]}]  
Explanation:  
let start = Date.now();  
function log(...inputs) {   
  console.log([Date.now() - start, inputs ])  
}  
const dlog = debounce(log, 50);  
setTimeout(() => dlog(1), 50);  
setTimeout(() => dlog(2), 75);  
</br>
The 1st call is cancelled by the 2nd call because the 2nd call occurred before 100ms  
The 2nd call is delayed by 50ms and executed at 125ms. The inputs were (2).  


---

### 💫 debounce

Debounce is a fundamental programming technique that delays function execution and cancels previous pending executions when the function is called repeatedly within a time window. It's essential for performance optimization and user experience.

🔧 How It Works Step-by-Step:
1. First Call:
    ```js
    // timeoutId is undefined
    clearTimeout(undefined); // Does nothing
    timeoutId = setTimeout(() => fn(), delay); // Schedule execution
    ```
2. Second Call (within delay period):
    ```js
    // timeoutId exists from previous call
    clearTimeout(timeoutId); // Cancel previous execution ✅
    timeoutId = setTimeout(() => fn(), delay); // Schedule new execution
    ```

