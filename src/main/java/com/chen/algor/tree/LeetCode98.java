package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class LeetCode98 {

    public Boolean isValidBST(TreeNode root) {

        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private Boolean isValidBSTHelper(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
             return true;
        }

        // 检查是否在合理的范围之内
        if (root.val <= minValue || root.val >= maxValue) {
              return false;
        }
        // 左子树肯定是小于当前的值，右子树肯定是大于当前值的
        return isValidBSTHelper(root.left, minValue, root.val)
                && isValidBSTHelper(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        System.out.println(new LeetCode98().isValidBST(treeNode));
    }
}
