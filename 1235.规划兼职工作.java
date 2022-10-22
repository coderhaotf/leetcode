/*
 * @lc app=leetcode.cn id=1235 lang=java
 *
 * [1235] 规划兼职工作
 */

// @lc code=start
class Solution {
    private static int max = 0;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        backtrack(0, 0, startTime, endTime, profit);
        return max;
    }

    private static void backtrack(int start, int res, int[] startTime, int[] endTime, int[] profit) {
        int length = startTime.length;
        if (start >= length) {
            max = Math.max(max, res);
            return;
        }
        for (int i = start; i < length; i++) {
            int right = endTime[i];
            int next = i + 1;
            while (next < length && startTime[next] < right) {
                next++;
            }
            res += profit[i];
            backtrack(next, res, startTime, endTime, profit);
            res -= profit[i];
        }
    }
}
// @lc code=end
