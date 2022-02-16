import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private List<TreeNode> list = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return list;
    }

    private String traverse(TreeNode root) {
        if (root == null)
            return "#";
        String str = traverse(root.left) + ',' + traverse(root.right) + ',' + root.val;
        if (map.getOrDefault(str, 0) == 1) {
            list.add(root);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}
// @lc code=end
