## 2622. Cache With Time Limit

🔗 [Link](https://leetcode.com/problems/cache-with-time-limit/description/)

**📝 Topic: cache**

Write a class that allows getting and setting key-value pairs, however a time until expiration is associated with each key.

The class has three public methods:

set(key, value, duration): accepts an integer key, an integer value, and a duration in milliseconds. Once the duration has elapsed, the key should be inaccessible. The method should return true if the same un-expired key already exists and false otherwise. Both the value and duration should be overwritten if the key already exists.

get(key): if an un-expired key exists, it should return the associated value. Otherwise it should return -1.

count(): returns the count of un-expired keys.


----


### 💫 Cache Implementation

Every time a key-value pair is placed in the cache, we can also create a timer that deletes that key after the expiration time has elapsed. However, we need to be careful with this approach because what happens if we overwrite an existing key before the time expires? It will cause the new key to get prematurely deleted. For this reason, we need to maintain a reference to the timer so we can clear it if the key gets overwritten.

Key Learning: Understanding how expiring data structures work in real systems.