package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

/**
 * 判断两个二叉树是不是相同
 */
public class LeetCode100 {

    /**
     * 就是找一个人一个不同的树
     * @param p
     * @param q
     * @return
     */
    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
             return true;
        }
        if (p == null || q == null) {
             return false;
        }
        if (p.val != q.val) {
             return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

}
