import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int end = points[0][1];
        int count = 1;

        for (int i = 0; i < points.length; i++) {
            int start = points[i][0];
            if (start > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
// @lc code=end
