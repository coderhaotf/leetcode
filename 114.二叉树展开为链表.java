/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode parent = new TreeNode();
        traverse(root, parent);
    }

    private TreeNode traverse(TreeNode root, TreeNode parent) {
        if (root == null)
            return parent;
        parent.right = root;
        parent = parent.right;
        TreeNode left = parent.left;
        TreeNode right = parent.right;
        parent.left = null;
        parent = traverse(left, parent);
        parent = traverse(right, parent);
        return parent;
    }
}
// @lc code=end
