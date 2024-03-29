/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    private int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        return traverse(root, k).val;
    }

    private TreeNode traverse(TreeNode root, int k) {
        if (root == null)
            return null;
        TreeNode left = traverse(root.left, k);
        if (left != null)
            return left;

        rank++;
        if (rank == k) {
            return root;
        }
        TreeNode right = traverse(root.right, k);
        return right;
    }
}
// @lc code=end
