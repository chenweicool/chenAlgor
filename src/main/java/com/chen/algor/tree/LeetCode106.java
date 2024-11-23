package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 和105道题相同的，改造下就行
 */
public class LeetCode106 {
    // 声明一个map存储中序元素结果
    private Map<Integer, Integer> orderMap;

    private int preIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        orderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            orderMap.put(inorder[i], i);
        }
        preIndex = postOrder.length - 1;
        return buildTreeHelper(postOrder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        // 筛选出根节点
        int rootVal = postOrder[preIndex--];
        TreeNode root = new TreeNode(rootVal);

        // 找到跟根节点在中序遍历的位置
        int rootIndex = orderMap.get(rootVal);

        // 这里顺序不能变，因为后序遍历根节点紧挨着右子树，所以先构造右子树
        root.right = buildTreeHelper(postOrder, rootIndex + 1, end);
        root.left = buildTreeHelper(postOrder, start, rootIndex - 1);
        return root;
    }

    public static void main(String[] args) {
        LeetCode106 solution = new LeetCode106();

        // 示例数据
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preorder, inorder);

        // 中序遍历打印二叉树
        inorderTree(root);
    }

    private static void inorderTree(TreeNode root) {
        if (root != null) {
            inorderTree(root.left);
            System.out.println(root.val);
            inorderTree(root.right);
        }
    }
}
