## 2667. Create Hello World Function

🔗 [Link](https://leetcode.com/problems/create-hello-world-function/description/)

**📝 Topic: JavaScript Function**

Write a function createHelloWorld. It should return a new function that always returns "Hello World".

**Example 1:**

Input: args = []

Output: "Hello World"

Explanation:
- const f = createHelloWorld();
- f(); // "Hello World"

The function returned by createHelloWorld should always return "Hello World".

**Example 2:**

Input: args = [{},null,42]

Output: "Hello World"

Explanation:
- const f = createHelloWorld();
- f({}, null, 42); // "Hello World"

Any arguments could be passed to the function but it should still always return "Hello World".

</br>

### Implement
See the js code file

</br>

### 💫 JavaScript functions

**Using "function" syntax to declare function:**
  - Basic
    ```js
    function f(a, b) {
      const sum = a + b;
      return sum;
    }
    console.log(f(3, 4)); // 7
    ```

  - Anonymous Function
    ```js
    var f = function(a, b) {
      const sum = a + b;
      return sum;
    }
    console.log(f(3, 4)); // 7
    ```

  - Immediately Invoked Function Expression (IIFE): create a function and immediately execute it in Javascript
    ```js
    const result = (function(a, b) {
      const sum = a + b;
      return sum;
    })(3, 4);
    console.log(result); // 7
    ```

  - Function Hoisting: a function can sometimes be used before it is initialized, only if you declare functions with the function syntax


**Closures!**

Functions in JavaScript have access to variables outside of their scope.

 ```js
function createCounter(){
  let value = 0; // Hidden State

  // Because of "Closures", increment() function have access to "value"
  function increment(){
    return ++value;
  }

  return{
    increment: increment
  }
}

// Object
const counter1 = createCounter();
const counter2 = createCounter();

console.log(counter1.increment()); // 1
console.log(counter1.increment()); // 2

console.log(counter2.increment()); // 1


 ```

**Arrow Syntax:** The other common way to declare functions is with arrow syntax. In fact, on many projects, it is the preferred syntax.
- Basic Syntax
  ```js
  const f = (a, b) => {
      const sum = a + b;
      return sum;
  };
  console.log(f(3, 4)); // 7
  ```

- Omit Return
  ```js
  const f = (a, b) =>  a + b;
  console.log(f(3, 4)); // 7
  ```






