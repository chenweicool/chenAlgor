package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class LeetCode105 {

    Map<Integer,Integer> inorderMap;

    private int preOrderIndex = 0;
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        inorderMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inorderMap.put(inOrder[i], i);
        }
        return buildTreeHelper(preOrder, 0, preOrder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preOrder, int inOrderStart, int intOrderEnd) {
        // 递归终结条件
        if (inOrderStart > intOrderEnd) {
            return null;
        }
        // 获取根节点的值
        int rootVal = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderMap.get(rootVal);

        root.left = buildTreeHelper(preOrder, inOrderStart, rootIndex - 1);
        root.right = buildTreeHelper(preOrder, rootIndex + 1, intOrderEnd);
        return root;
    }

    public static void main(String[] args) {

    }
}
