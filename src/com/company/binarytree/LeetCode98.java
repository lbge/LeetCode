package com.company.binarytree;

/**
 * 98. 验证二叉搜索树
 */
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long small, long big) {
        if (node == null) {
            return true;
        }
        if (node.val <= small || node.val >= big) {
            return false;
        }
        return valid(node.left, small, node.val) && valid(node.right, node.val, big);
    }
}
