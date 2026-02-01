## 

🔗 [Link]()

**📝 Topic: Doubly LinkedList, HashMap**

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

**Example 1:**

> Input  
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]  
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]  
Output  
[null, null, null, 1, null, -1, null, -1, 3, 4]  
  
Explanation  
LRUCache lRUCache = new LRUCache(2);  
lRUCache.put(1, 1); // cache is {1=1}  
lRUCache.put(2, 2); // cache is {1=1, 2=2}  
lRUCache.get(1);    // return 1  
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}  
lRUCache.get(2);    // returns -1 (not found)  
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}  
lRUCache.get(1);    // return -1 (not found)  
lRUCache.get(3);    // return 3  
lRUCache.get(4);    // return 4  

**Constraints:**

- 1 <= capacity <= 3000
- 0 <= key <= 104
- 0 <= value <= 105
- At most 2 * 105 calls will be made to get and put.

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input linkedList be empty? Yes, return empty [] in this case
2. Any requirement on time/space complexity? Time complexity be O(1) for fast lookup and fast remove

### Match
_See if this problem matches any data structures, algorithms_

**What is a Cache?**

A cache is a hardware or software component that stores data so that future requests
for that data can be served faster; the data stored in a cache might be the result
of an earlier computation or a copy of data stored elsewhere.

**What Is An LRU Cache?**

So a LRU Cache is a storage of items so that future access to those items can
be serviced quickly and an LRU policy is used for cache eviction.

- HashMap (cache)
    - Key: integer
    - Value: reference/pointer to a Node
    - Purpose: O(1) lookup
- Doubly Linked List (left ↔ nodes ↔ right)
    - Nodes connected with prev and next pointers
    - Purpose: O(1) insertion/removal and maintain order

```md
HashMap (cache)                 Doubly Linked List
┌─────────────────┐            ┌──────────────────────────┐
│ Key  │  Value   │            │                          │
├──────┼──────────┤            │  left ←→ Node ←→ right   │
│  1   │ Node* ───┼───────────→│   ↑       ↑              │
│  2   │ Node* ───┼───────────────────────┘              │
│  3   │ Node* ───┼──→ (points to node)                  │
└──────┴──────────┘            └──────────────────────────┘

* Both structures point to THE SAME Node objects in memory
```

### Plan
_Walk through a implementation with an existing diagram_

1. 

### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

```java
// When you do put(1, 10):

// Step 1: Create a node
Node newNode = new Node(1, 10);

// Step 2: Add to HashMap
cache.put(1, newNode);  // HashMap now references this node

// Step 3: Insert into linked list
insert(newNode);  // Linked list now also references this node
```

```md
* After `put(1, 10)` and `put(2, 20)`:

HashMap:
{
  1 → points to Node(1,10),
  2 → points to Node(2,20)
}

Linked List:
left ←→ Node(1,10) ←→ Node(2,20) ←→ right
```

### Evaluate

Time Complexity: O(1) fast lookup and fast remove

Space Complexity: O(n)
