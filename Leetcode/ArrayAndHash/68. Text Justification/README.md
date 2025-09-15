## 68. Text Justification

🔗 [Link](https://leetcode.com/problems/text-justification/description/)

**📝 Topic: Array, String Manipulation**

You are given an array of strings `words` and a width `maxWidthv, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly `maxWidth` characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

- A word is defined as a character sequence consisting of non-space characters only.
- Each word's length is guaranteed to be greater than `0` and not exceed `maxWidth`.
- The input array `words` contains at least one word.

**Example 1:**

> Input: words = ["This","is","an","example","of","text","justification."], maxWidth = 16  
> Output: [  
   "This    is    an",  
   "example  of text",  
   "justification.  "  
]  

**Example 2:**

> Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16   
> Output: [  
  "What   must   be",  
  "acknowledgment  ",  
  "shall be        "  
]  

Explanation: Note that the last line is "shall be " instead of "shall be", because the last line must be left-justified instead of fully-justified.

Note that the second line is also left-justified because it contains only one word.

**Constraints:**

- 1 <= words.length <= 300
- 1 <= words[i].length <= 20
- words[i] consists of only English letters and symbols.

----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input array be empty? No
2. Any request for time and space complexity? O(n∗m) for both time and space

### Match
_See if this problem matches any data structures, algorithms_

- The hard part for this question is to read and understand the requirements!
- String Manipulation & Text Processing:
    - This is fundamentally about precise string handling - you need to carefully calculate lengths, distribute spaces, and build formatted strings character by character. It's excellent practice for problems involving exact formatting requirements.

### Plan
_Walk through a implementation with an existing diagram_

- Greedy Line Packing
    ```md
    // Critical condition: when does a line become "full"?
    if(length + line.size() + words[i].length() > maxWidth)
    ```
    Key insight: line.size() represents minimum spaces needed (one space between each word). This is the core greedy decision - pack as many words as possible before hitting the width limit.

- Mathematical Distribution Logic:
    - The space distribution rule is key: "if spaces don't divide evenly, left slots get more spaces." This teaches you how to handle remainder distribution mathematically:
        ```md
        int extraSpace = maxWidth - length;  // Total spaces needed
        int space = extraSpace / Math.max(1, (line.size() - 1));  // Base spaces per gap
        int remainder = extraSpace % Math.max(1, (line.size() - 1));  // Extra spaces for left gaps
        ```
    - Division gives base spaces for each gap
    - Remainder determines how many left gaps get +1 extra space
    - Math.max(1, ...) prevents division by zero for single-word lines
- Edge Case Handling
    - Last line (left-justified only)
    - Single word lines (no justification needed)
    - Lines that exactly fit (no extra spaces needed)

### Implement
_See the solution file_

### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(m*n)
Where n is the number of words in array and m is the average length of the words.

Space Complexity: O(m*n)
