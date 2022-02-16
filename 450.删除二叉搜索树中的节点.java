/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    public TreeNode deleteNode(TreeNode root, int key) {
        return traverse(root, key);
    }

    private TreeNode traverse(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.left == null && root.right == null)
                return null;
            if (root.left != null && root.right == null)
                return root.left;
            if (root.right != null && root.left == null)
                return root.right;
            if (root.left != null && root.right != null) {
                TreeNode tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                tmp.right = deleteNode(root.right, tmp.val);
                tmp.left = root.left;
                return tmp;
            }
        }
        if (root.val > key) {
            root.left = traverse(root.left, key);
        } else {
            root.right = traverse(root.right, key);
        }
        return root;
    }
}
// @lc code=end
