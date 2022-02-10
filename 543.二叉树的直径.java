/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左右子树高度
        int left = traverse(root.left);
        int right = traverse(root.right);
        // 更新最大直径
        maxDiameter = Math.max(left + right, maxDiameter);

        return 1 + Math.max(left, right);
    }
}
// @lc code=end
