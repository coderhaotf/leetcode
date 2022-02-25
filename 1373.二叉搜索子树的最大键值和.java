/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
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
    private int maxSum = 0;
    private int sumIndex = 0;
    private int maxIndex = 1;
    private int minIndex = 2;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    private int[] traverse(TreeNode root) {
        if (root == null)
            return new int[] { 0, Integer.MIN_VALUE, Integer.MAX_VALUE };
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] result = new int[3];
        // 二叉搜索树
        if (root.val > left[maxIndex] && root.val < right[minIndex]) {
            result[sumIndex] = left[sumIndex] + right[sumIndex] + root.val;
            result[maxIndex] = Math.max(root.val, right[maxIndex]);
            result[minIndex] = Math.min(root.val, left[minIndex]);
            maxSum = Math.max(maxSum, result[sumIndex]);
        } else {
            return new int[] { 0, Integer.MAX_VALUE, Integer.MIN_VALUE };
        }
        return result;
    }
}
// @lc code=end
