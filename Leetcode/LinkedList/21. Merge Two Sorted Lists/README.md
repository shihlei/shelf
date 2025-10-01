## 21. Merge Two Sorted Lists

🔗 [Link](https://leetcode.com/problems/merge-two-sorted-lists/description/)

**📝 Topic: LinkedList**

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

**Example 1:**

> Input: list1 = [1,2,4], list2 = [1,3,4]  
Output: [1,1,2,3,4,4]  

**Example 2:**

> Input: list1 = [], list2 = []  
Output: []  

**Example 3:**

> Input: list1 = [], list2 = [0]  
Output: [0]  

**Constraints:**

- The number of nodes in both lists is in the range [0, 50].
- -100 <= Node.val <= 100
- Both list1 and list2 are sorted in non-decreasing order.

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input linkedList be empty? Yes, return empty [] in this case
2. Is linkedList have cycle? No
3. Any requirement on time/space complexity? space complexity be O(1)

### Match
_See if this problem matches any data structures, algorithms_

Brute force:
- Storing the values of both linked lists in an array, sorting the array, and then converting it back into a linked list
- This approach would use O(n) extra space 

LinkedList:
- Sorted nature of the lists can be leveraged

### Plan
_Walk through a implementation with an existing diagram_

Ideas:
1. We create a dummy node to keep track of the head of the resulting linked list while iterating through the lists
2. Using l1 and l2 as iterators for list1 and list2, respectively, we traverse both lists node by node to build a final linked list that is also sorted
3. Add the rest of nodes from l1 or l2 into the result linkedList


### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n + m)

Space Complexity: O(1)

Where n is the length of list1 and m is the length of list2
