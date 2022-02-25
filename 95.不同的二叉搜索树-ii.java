import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return traverse(1, n);
    }

    private List<TreeNode> traverse(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (end < start) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lList = traverse(start, i - 1);
            List<TreeNode> rList = traverse(i + 1, end);
            for (int l = 0; l < lList.size(); l++) {
                for (int r = 0; r < rList.size(); r++) {
                    TreeNode node = new TreeNode(i);
                    node.left = lList.get(l);
                    node.right = rList.get(r);
                    list.add(node);
                }
            }
        }
        return list;
    }
}
// @lc code=end
