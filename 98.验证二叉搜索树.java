/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * long val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(long val) { this.val = val; }
 * TreeNode(long val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // return valid(root, null, null);
        long[] result = traverse(root);
        return result[0] == 1;
    }

    private boolean valid(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null)
            return true;
        if (max != null && max.val <= root.val)
            return false;
        if (min != null && min.val >= root.val)
            return false;

        return valid(root.left, root, min) && valid(root.right, max, root);
    }

    private long[] traverse(TreeNode root) {
        if (root == null)
            return new long[] { 1, Long.MAX_VALUE, Long.MIN_VALUE };

        long[] left = traverse(root.left);
        long[] right = traverse(root.right);

        if (left[0] == 0 || right[0] == 0)
            return new long[] { 0 };
        if (root.val > left[2] && root.val < right[1])
            return new long[] { 1, Math.min(left[1], root.val), Math.max(right[2], root.val) };
        return new long[] { 0 };
    }
}
// @lc code=end
