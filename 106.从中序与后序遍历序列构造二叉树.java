/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traverse(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode traverse(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (pEnd < pStart || iEnd < iStart)
            return null;

        int root = postorder[pEnd];
        int index = getMaxIndex(inorder, iStart, iEnd, root);
        int gap = index - iStart;

        TreeNode left = traverse(inorder, iStart, index - 1, postorder, pStart, pStart + gap - 1);
        TreeNode right = traverse(inorder, index + 1, iEnd, postorder, pStart + gap, pEnd - 1);

        TreeNode node = new TreeNode(root);
        node.left = left;
        node.right = right;
        return node;
    }

    private int getMaxIndex(int[] nums, int start, int end, int max) {
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == max) {
                max = nums[i];
                index = i;
                break;
            }
        }
        return index;
    }
}
// @lc code=end
