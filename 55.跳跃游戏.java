/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return true;
        int len = nums.length;
        int farthest = 0;

        for (int i = 0; i < len - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i)
                return false;
        }

        return farthest >= len - 1;
    }
}
// @lc code=end
