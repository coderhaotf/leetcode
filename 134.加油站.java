/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < cost.length; i++) {
            sum = sum + gas[i] - cost[i];
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        if (sum < 0 || start == gas.length)
            return -1;
        return start;
    }
}
// @lc code=end
