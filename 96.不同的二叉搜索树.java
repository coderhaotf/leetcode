/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    private int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int start, int end) {
        if (start >= end)
            return 1;
        if (memo[start][end] != 0)
            return memo[start][end];

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += count(start, i - 1) * count(i + 1, end);
        }
        memo[start][end] = sum;
        return sum;
    }
}
// @lc code=end
