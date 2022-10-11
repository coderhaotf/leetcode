import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Boolean> visited = new HashMap<>();
        // 记录每个字符的个数
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            visited.put(s.charAt(i), false);
        }

        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (visited.get(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }
            while (stack.size() > 0) {
                Character peek = stack.peek();
                if (peek >= c && map.get(peek) > 1) {
                    visited.put(peek, false);
                    stack.pop();
                    map.put(peek, map.get(peek) - 1);
                } else {
                    break;
                }
            }
            stack.push(c);
            visited.put(c, true);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
// @lc code=end
