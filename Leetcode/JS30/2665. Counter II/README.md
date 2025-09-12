## 2665. Counter II

🔗 [Link](https://leetcode.com/problems/counter-ii/description/)

**📝 Topic: Closures, Object and Class**

Write a function createCounter. It should accept an initial integer init. It should return an object with three functions.

The three functions are:

- increment() increases the current value by 1 and then returns it.
- decrement() reduces the current value by 1 and then returns it.
- reset() sets the current value to init and then returns it.

**Example 1:**

>Input: init = 5, calls = ["increment","reset","decrement"]  
Output: [6,5,4]  
Explanation:  
const counter = createCounter(5);  
counter.increment(); // 6  
counter.reset(); // 5  
counter.decrement(); // 4  


  ----


### 💫 Closure

We can declare a variable currentCount and set it equal to init. Then return an object with the three functions where we increment, decrement, and reset the currentCount.

- Objects
  - are just mappings from strings to other values. The values can be anything: strings, functions, other objects, etc. The string that maps to the value is called the key.

**How it applies here**
```js
const object = {
  "num": 1,
  "str": "Hello World",
  "obj": {
    "x": 5
  }
};

//One way to access values on an object
const val = object.obj.x;
console.log(val); // 5
```

### 💫 Classes

- You can also define classes in JavaScript. The classes's **constructor** returns an object which is an instance of that class.
- In class, don't need "function" syntax for functions

```js
class createCounter{
    constructor(init){
        this.init = init; // init will out of scope
        this.count= init;
    }

    // Don't need "function" keyword for function in class
    increment(){
        return ++this.count;
    }

    reset = () => {
        this.count = this.init;
        return this.count;
    }
}

const counter = new createCounter(5);
counter.increment(); // 6
counter.reset(); // 5
```

### Implement
See the js code file

### Evaluate

Time Complexity: O(1)

Space Complexity: O(1)
