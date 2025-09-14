## 2621. Sleep

🔗 [Link](https://leetcode.com/problems/sleep/description/)

**📝 Topic: asynchronous**

Given a positive integer millis, write an asynchronous function that sleeps for millis milliseconds. It can resolve any value.

Note that minor deviation from millis in the actual sleep duration is acceptable.


**Example 1:**

> Input: millis = 100  
Output: 100  
Explanation: It should return a promise that resolves after 100ms.  
let t = Date.now();  
sleep(100).then(() => {  
  console.log(Date.now() - t); // 100  
});  

**Example 2:**

> Input: millis = 200  
Output: 200  
Explanation: It should return a promise that resolves after 200ms.  


---

### 💫 Asynchronous

What is Async? 

Asynchronous JavaScript means your code can start a task and continue running without waiting for it to finish. This is crucial because JavaScript runs on a **single thread** - without async programming, your entire application would freeze whenever you make a network request, read a file, or wait for a user action.

Asynchronous (Non-blocking):
```js
console.log("1. Start");

setTimeout(() => {
    console.log("2. Async operation completed");
}, 1000);

console.log("3. End");

// Output (immediate):
// 1. Start
// 3. End
// 2. Async operation completed (after 1 second)
```

How it works:

1. Synchronous code executes immediately on the call stack
2. Asynchronous operations are sent to browser APIs (timers, network, etc.)
3. When async operations complete, their **callbacks** go to the queue
4. Event loop moves callbacks from queue to call stack when it's empty


**Promise**

What is promise?
- Promises in JavaScript are objects that represent the eventual completion (or failure) of an asynchronous operation. Think of them as "placeholders" for values that don't exist yet but will be available in the future.
- Three states: Pending, Resolved, and Rejected


```js
// 1. Pending - initial state
// every promise takes callback function
const promise = new Promise((resolve, reject) => {
    // Async operation in progress
});

// 2. Resolvved - operation completed successfully
promise.then(result => {
    console.log("Success:", result);
});

// 3. Rejected - operation failed
promise.catch(error => {
    console.error("Error:", error);
});

```

**Async & Await**

async Functions

An async function always returns a **Promise**. When you declare a function as async, you can use await inside it:
```js
async function fetchData() {
    return "Hello World"; // This automatically gets wrapped in a Promise
}

// Equivalent to:
function fetchData() {
    return Promise.resolve("Hello World");
}
```

await Keyword

await pauses the execution of an async function until a Promise resolves, then returns the resolved value:
```js
async function getData() {
    const response = await fetch('https://api.example.com/data');
    const data = await response.json();
    return data;
}
```

**Callback (The problem)**

Callbacks are functions passed as arguments to other functions, executed after an async operation completes. This was the original way to handle async operations in JavaScript.

- Functions passed to other functions
- Executed after async operations complete
- Problem: "Callback hell" with nested functions
- Hard to read, debug, and handle errors
