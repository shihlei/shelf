## 2637. Promise Time Limit

🔗 [Link](https://leetcode.com/problems/promise-time-limit/description/)

**📝 Topic: asynchronous**

Given an asynchronous function fn and a time t in milliseconds, return a new time limited version of the input function. fn takes arguments provided to the time limited function.

The time limited function should follow these rules:

- If the fn completes within the time limit of t milliseconds, the time limited function should resolve with the result.
- If the execution of the fn exceeds the time limit, the time limited function should reject with the string "Time Limit Exceeded".


**Example 1:**

> Input:  
fn = async (n) => {   
  await new Promise(res => setTimeout(res, 100));   
  return n * n;   
}  
inputs = [5]  
t = 150  
Output: {"resolved":25,"time":100}  
Explanation:  
The function resolved 5 * 5 = 25 at t=100ms. The time limit is never reached.  


---

Approach 1: Call Function Inside New Promise + Clearing Timeout

We can create a new Promise that resolves as soon as the passed function resolves or rejects. This essentially emulates the passed function without effecting it at all. To satisfy the requirement, all we have to do is add a setTimeout which can force the promise to reject prematurely.

Approach 2: Async/Await + Clearing Timeout

You can only use the await keyword inside an async function, so we must add the async keyword to the callback passed to new Promise. Now the callback returns a promise, instead of undefined.

