## 2021. Brightest Position on Street

🔗 [Link](https://leetcode.com/problems/brightest-position-on-street/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: Array, Interval, Sweep Line Algorithm**

A perfectly straight street is represented by a number line. The street has street lamp(s) on it and is represented by a 2D integer array lights. Each lights[i] = [positioni, rangei] indicates that there is a street lamp at position positioni that lights up the area from [positioni - rangei, positioni + rangei] (inclusive).

The brightness of a position p is defined as the number of street lamp that light up the position p.

Given lights, return the brightest position on the street. If there are multiple brightest positions, return the smallest one.


**Example 1:**

> Input: lights = [[-3,2],[1,2],[3,3]]  
Output: -1  
Explanation:  
The first street lamp lights up the area from [(-3) - 2, (-3) + 2] = [-5, -1].  
The second street lamp lights up the area from [1 - 2, 1 + 2] = [-1, 3].  
The third street lamp lights up the area from [3 - 3, 3 + 3] = [0, 6].  
</br>
Position -1 has a brightness of 2, illuminated by the first and second street light.  
Positions 0, 1, 2, and 3 have a brightness of 2, illuminated by the second and third street light.  
Out of all these positions, -1 is the smallest, so return it.  

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can positions be negative? (Assume yes, it's a number line)
2. Can ranges be 0? (Assume yes, lamp only lights its own position)
3. Are there always lamps? (Assume yes, array is non-empty)

### Match
_See if this problem matches any data structures, algorithms_

1. Brute Force: Check every possible position → Too slow
2. Sweep Line: Process start/end events → Optimal O(n log n)

### Plan
_Walk through a implementation with an existing diagram_

Use Sweep Line to track brightness changes as we move along the number line.

1. Create Events: For each lamp [pos, range]:
    - Add event (pos - range, +1) (brightness increases)
    - Add event (pos + range + 1, -1) (brightness decreases)
2. Sort Events: By position, with tie-breaking (-1 before +1)
3. Sweep Through Events:
    - Track current brightness
    - Update maximum brightness and position
4. Handle Ties: Keep smallest position when brightness is tied

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n log n)

Space Complexity: O(n)