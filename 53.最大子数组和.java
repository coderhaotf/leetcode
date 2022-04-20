/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum < 0)
                sum = 0;
            sum = sum + nums[i];
            max = Math.max(sum, max);
        }

        return max;
    }
}
// @lc code=end
