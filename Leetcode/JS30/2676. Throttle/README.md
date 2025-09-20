## 2676. Throttle

🔗 [Link](https://leetcode.com/problems/throttle/description/)

**📝 Topic: throttle**

Given a function fn and a time in milliseconds t, return a throttled version of that function.

A throttled function is first called without delay and then, for a time interval of t milliseconds, can't be executed but should store the latest function arguments provided to call fn with them after the end of the delay.

For instance, t = 50ms, and the function was called at 30ms, 40ms, and 60ms.

At 30ms, without delay, the throttled function fn should be called with the arguments, and calling the throttled function fn should be blocked for the following t milliseconds.

At 40ms, the function should just save arguments.

At 60ms, arguments should overwrite currently stored arguments from the second call because the second and third calls are made before 80ms. Once the delay has passed, the throttled function fn should be called with the latest arguments provided during the delay period, and it should also create another delay period of 80ms + t.

**Example 1:**

> Input:  
t = 100,   
calls = [  
  {"t":20,"inputs":[1]}  
]  
Output: [{"t":20,"inputs":[1]}]  
Explanation: The 1st call is always called without delay  

**Example 2:**

> Input:  
t = 50,   
calls = [  
  {"t":50,"inputs":[1]},  
  {"t":75,"inputs":[2]}  
]  
Output: [{"t":50,"inputs":[1]},{"t":100,"inputs":[2]}]  
Explanation:   
The 1st is called a function with arguments (1) without delay.  
The 2nd is called at 75ms, within the delay period because 50ms + 50ms = 100ms, so the next call can be   reached at 100ms. Therefore, we save arguments from the 2nd call to use them at the callback of the 1st call.  

---

### 💫 throttle

The one-sentence description of throttle is that it should call the provided callback as frequently as possible but no more frequently than t milliseconds. 

1. Init variables to tracks cooldown period and store latest arguments furing throttle period
2. Execute first, then throttle
3. Self-Recursive Timer using `setTimeout(helper, t)`

Throttle vs Debounce Comparison:

Throttle:
- DebounceExecute immediately
- Fixed intervals during activity
- Latest args during cooldown
- Continuous execution while active

Debounce:
- Always delay execution
- Resets timer on each call
- Latest args when timer expires
- Single execution after silence

