import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 0, 3, 0);
    }

    private List<List<Integer>> nSum(int[] nums, int start, int n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < n || n < 2)
            return res;

        if (n == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int low = nums[left];
                int high = nums[right];
                if (sum < target) {
                    while (nums[left] == low && left < right)
                        left++;
                } else if (sum > target) {
                    while (nums[right] == high && left < right)
                        right--;
                } else {
                    List<Integer> rList = new ArrayList<>();
                    rList.add(nums[left]);
                    rList.add(nums[right]);
                    res.add(rList);
                    while (nums[left] == low && left < right)
                        left++;
                    while (nums[right] == high && left < right)
                        right--;
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> result = nSum(nums, i + 1, n - 1, target - nums[i]);

                for (List<Integer> list : result) {
                    list.add(0, nums[i]);
                    res.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }
        return res;
    }
}
// @lc code=end
