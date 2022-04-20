/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];

        int max = 1;
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1;
        }

        for (int i = 0; i < memo.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
            }
            max = Math.max(max, memo[i]);
        }

        return max;
    }
}
// @lc code=end
