package leetcode.editor.cn;

//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
//
// 注意:
//
//
// num 的长度小于 10002 且 ≥ k。
// num 不会包含任何前导零。
//
//
// 示例 1 :
//
//
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
//
//
// 示例 2 :
//
//
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//
//
// 示例 3 :
//
//
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
//
// Related Topics 栈 贪心算法
// 👍 391 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> characters = new LinkedList<Character>();
        // 保持头部单调不减
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!characters.isEmpty() && characters.getLast() > c && k > 0) {
                characters.removeLast();
                k--;
            }
            characters.add(c);
        }
        // 因为是单调不减，所以从尾部删除最大的
        for (int i = 0; i < k; i++) {
            characters.removeLast();
        }
        // 删除前导零
        while (!characters.isEmpty() && characters.get(0) == '0') {
            characters.removeFirst();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < characters.size(); i++) {
            stringBuilder.append(characters.get(i));
        }
        return stringBuilder.length() > 0 ? stringBuilder.toString() : "0";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
