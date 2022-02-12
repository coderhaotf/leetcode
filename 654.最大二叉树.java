/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums, 0, nums.length - 1);
    }

    private TreeNode traverse(int[] nums, int start, int end) {
        if (end < start)
            return null;
        // 获取最大值的key、value
        int[] values = getMaxKeyVal(nums, start, end);
        int max = values[0];
        int index = values[1];
        // 递归处理左右节点
        TreeNode left = traverse(nums, start, index - 1);
        TreeNode right = traverse(nums, index + 1, end);

        TreeNode node = new TreeNode(max);
        node.left = left;
        node.right = right;
        return node;
    }

    private int[] getMaxKeyVal(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return new int[] { max, index };
    }
}
// @lc code=end
