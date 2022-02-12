/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traverse(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode traverse(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pEnd < pStart || iEnd < iStart)
            return null;

        int root = preorder[pStart];
        int index = getMaxIndex(inorder, iStart, iEnd, root);
        int gap = index - iStart;

        TreeNode left = traverse(preorder, pStart + 1, pStart + gap, inorder, iStart, index - 1);
        TreeNode right = traverse(preorder, pStart + gap + 1, pEnd, inorder, index + 1, iEnd);

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
