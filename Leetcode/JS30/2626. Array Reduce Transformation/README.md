## 2626. Array Reduce Transformation

🔗 [Link](https://leetcode.com/problems/array-reduce-transformation/description/)

**📝 Topic: reduce(), callback, functional programming**

Given an integer array nums, a reducer function fn, and an initial value init, return the final result obtained by executing the fn function on each element of the array, sequentially, passing in the return value from the calculation on the preceding element.

This result is achieved through the following operations: val = fn(init, nums[0]), val = fn(val, nums[1]), val = fn(val, nums[2]), ... until every element in the array has been processed. The ultimate value of val is then returned.

If the length of the array is 0, the function should return init.

Please solve it without using the built-in Array.reduce method.

**Example 1:**

> Input:   
nums = [1,2,3,4]  
fn = function sum(accum, curr) { return accum + curr; }  
init = 0  
Output: 10  
Explanation:  
initially, the value is init=0.  
(0) + nums[0] = 1  
(1) + nums[1] = 3  
(3) + nums[2] = 6  
(6) + nums[3] = 10  
The final answer is 10.  
> 

---

```
Programming Paradigms
│
├── IMPERATIVE
│   ├── Procedural (C, Pascal)
│   ├── Object-Oriented (Java, C++)
│   └── Assembly language
│
└── DECLARATIVE
    ├── Functional Programming ← map(), filter(), reduce()
    ├── Logic Programming (Prolog)
    └── Query Languages (SQL, GraphQL)
```

### Functional programming
- You're programming with functions as your primary tool, focusing on transforming data rather than changing state!
- map(), filter(), and reduce() are core functional programming methods.

### Implement
See the js code file
