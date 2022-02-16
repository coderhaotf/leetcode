/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    private int res = 0;

    public TreeNode convertBST(TreeNode root) {
        return traverse(root);
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null)
            return null;
        traverse(root.right);
        res = res + root.val;
        root.val = res;
        traverse(root.left);
        return root;
    }
}
// @lc code=end
