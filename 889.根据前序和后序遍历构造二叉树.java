/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return traverse(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode traverse(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preEnd < preStart || postEnd < postStart)
            return null;
        if (preEnd == preStart) {
            return new TreeNode(preorder[preStart]);
        }

        int leftRootVal = preorder[preStart + 1];
        int index = getMaxIndex(postorder, postStart, postEnd, leftRootVal);
        int leftSize = index - postStart + 1;

        TreeNode left = traverse(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        TreeNode right = traverse(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);

        TreeNode node = new TreeNode(preorder[preStart]);
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
