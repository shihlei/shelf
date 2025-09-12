## 2666. Allow One Function Call

🔗 [Link](https://leetcode.com/problems/allow-one-function-call/description/)

**📝 Topic: Function Execution Control**

Given a function fn, return a new function that is identical to the original function except that it ensures fn is called at most once.

- The first time the returned function is called, it should return the same result as fn.
- Every subsequent time it is called, it should return undefined.

**Example 1:**

> Input: fn = (a,b,c) => (a + b + c), calls = [[1,2,3],[2,3,6]]      
Output: [{"calls":1,"value":6}]   
Explanation:  
const onceFn = once(fn);  
onceFn(1, 2, 3); // 6. 
onceFn(2, 3, 6); // undefined, fn was not called.   


---

### 💫 Function Execution Control

This problem teaches you how to create a wrapper function that limits when and how many times another function can be executed.

1. Closures for State Management

    ```js
    javascriptlet called = false; // This variable is "closed over" by the inner function
    return function(...args){ // Inner function has access to 'called'
        // The 'called' variable persists between function calls
    }
    ```

    Why this works:
    - The inner function forms a closure over the called variable
    - Each call to once() creates a new closure with its own called state
    - The called variable survives even after once() finishes executing

2. Higher-Order Functions

    ```js
    javascriptvar once = function(fn) { // Takes a function as parameter
        return function(...args){ // Returns a new function
            return fn.apply(this, args); // Calls the original function
        }
    }
    ```

    This is a higher-order function because it:

    - Takes a function as an argument
    - Returns a function
    - Decorates/modifies the behavior of the input function

3. Proper **this** Context and Arguments Handling

    ```js
    return fn.apply(this, args);
    // vs
    return fn(...args);

    ```

    Why apply(this, args)?
    - Preserves the this context from the caller
    - Handles any number of arguments dynamically

    apply() is perfect when you have:

    - Arguments in an array format
    - Need to set a specific this context


    In your once function, apply() ensures:

    - The original function's this context is preserved
    - All arguments are passed correctly, regardless of how many there are
