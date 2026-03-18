# LeetCode 455: Assign Cookies - Greedy Algorithm

## Problem Statement (Exact from LeetCode)
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that child i will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

**Note**:
- 1 <= g.length <= 3 * 10^4
- 1 <= s.length <= 3 * 10^4
- 1 <= s[j], g[i] <= 2^31 - 1

**Example 1**:
```
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. 
The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, 
you could only make the child whose greed factor is 1 content.
You need to output 1.
```

**Example 2**:
```
Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. 
The greed factors of 2 children are 1, 2. 
You have 3 cookies with size 1, 2, 3. 
You can assign cookie of size 1 to child 1 and cookie of size 2 to child 2. 
You need to output 2.
```

## Greedy Approach
1. Sort children's greed factors `g` ascending.
2. Sort cookie sizes `s` ascending.
3. Use two pointers:
   - Start from smallest greed and smallest cookie.
   - If cookie satisfies child (s[j] >= g[i]), assign and move both.
   - Else, discard cookie (move cookie pointer).

**Why Greedy works**: Assigning smallest possible cookie to smallest greed child leaves larger cookies for greedier children.

**Time Complexity**: O(n log n + m log m) - sorting dominates.
**Space Complexity**: O(1) or O(log n) for sort.

## Complete Java Solution
```java
package Greedy_algo;

import java.util.Arrays;

public class Assign_Cookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);  // Sort greed factors
        Arrays.sort(s);  // Sort cookie sizes
        
        int childIdx = 0, cookieIdx = 0, contentChildren = 0;
        
        while (childIdx < g.length && cookieIdx < s.length) {
            // If current cookie satisfies current child
            if (s[cookieIdx] >= g[childIdx]) {
                contentChildren++;
                childIdx++;  // Move to next child
            }
            cookieIdx++;  // Always try next cookie
        }
        
        return contentChildren;
    }
    
    public static void main(String[] args) {
        Assign_Cookies_455 sol = new Assign_Cookies_455();
        
        // Test case 1
        int[] g1 = {1,2,3};
        int[] s1 = {1,1};
        System.out.println("Example 1: " + sol.findContentChildren(g1, s1)); // 1
        
        // Test case 2
        int[] g2 = {1,2};
        int[] s2 = {1,2,3};
        System.out.println("Example 2: " + sol.findContentChildren(g2, s2)); // 2
    }
}
```

## How to Run
```bash
cd Greedy_algo
javac Assign_Cookies_455.java
java Assign_Cookies_455
```
**Expected Output**:
```
Example 1: 1
Example 2: 2
```

## Key Insights
- **Greedy Property**: Local optimum (smallest cookie for smallest greed) leads to global optimum.
- **Edge Cases**: All cookies too small, all children satisfied, empty arrays.
- **Optimization**: Sorting + two pointers is optimal O(n log n).

**Practice**: Implement for LeetCode submission!

