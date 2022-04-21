import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);
            right++;
            while (map.get(r) > 1) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }
}
// @lc code=end
