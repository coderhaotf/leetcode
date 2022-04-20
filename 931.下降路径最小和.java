/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // int len = matrix.length;
        // int dp[][] = new int[len][len];
        // dp[len - 1] = matrix[len - 1];
        // for (int i = len - 2; i >= 0; i--) {
        // for (int j = 0; j < len; j++) {
        // int min = matrix[i + 1][j];
        // if (j > 0) {
        // min = Math.min(min, matrix[i + 1][j - 1]);
        // }
        // if (j < len - 1) {
        // min = Math.min(min, matrix[i + 1][j + 1]);
        // }
        // dp[i][j] = min + matrix[i][j];
        // }
        // }
        // int minSum = Integer.MAX_VALUE;

        // for (int i = 0; i < len; i++) {
        // minSum = Math.min(minSum, dp[0][i]);
        // }
        // return minSum;
        int N = matrix.length;
        for (int r = N - 2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                int best = matrix[r + 1][c];
                if (c > 0)
                    best = Math.min(best, matrix[r + 1][c - 1]);
                if (c + 1 < N)
                    best = Math.min(best, matrix[r + 1][c + 1]);
                matrix[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : matrix[0])
            ans = Math.min(ans, x);
        return ans;
    }
}
// @lc code=end
