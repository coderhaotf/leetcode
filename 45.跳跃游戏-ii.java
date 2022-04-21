/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int farthest = 0;
        int step = 0;
        int point = 0;

        for (int i = 0; i < len - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (point == i) {
                point = farthest;
                step++;
            }
        }
        return step;
    }
}
// @lc code=end
