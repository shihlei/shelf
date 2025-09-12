## 2629. Function Composition

🔗 [Link](https://leetcode.com/problems/function-composition/description/)

**📝 Topic: reverse(), function composition, functional programming**

Given an array of functions [f1, f2, f3, ..., fn], return a new function fn that is the function composition of the array of functions.

The function composition of [f(x), g(x), h(x)] is fn(x) = f(g(h(x))).

The function composition of an empty list of functions is the identity function f(x) = x.

You may assume each function in the array accepts one integer as input and returns one integer as output.

**Example 1:**

>Input: functions = [x => x + 1, x => x * x, x => 2 * x], x = 4  
Output: 65   
Explanation:  
Evaluating from right to left ...  
Starting with x = 4.  
2 * (4) = 8  
(8) * (8) = 64  
(64) + 1 = 65   


----

### 💫 Function Composition
Function Composition is the process of combining two or more functions to produce a new function. When you compose functions f and g, you create a new function that applies g first, then applies f to the result.

Mathematical notation: (f ∘ g)(x) = f(g(x))

**Imperative Approach:**
```js
javascript// Step-by-step, procedural thinking
for(const fn of functions.reverse()){
    x = fn(x); // mutate x with each function result
}
```

**Functional Approach:**
```js
javascript// Declarative, functional thinking
return functions.reduceRight(fn, x);
// reduceRight naturally processes from right-to-left
```
</br>
The key difference between reduce() and reduceRight() is the direction they process the array, which is crucial for function composition

- reduce(): Processes left → right, accumulates from first to last
- reduceRight(): Processes right → left, accumulates from last to first


### Implement
See the js code file

