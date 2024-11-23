package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class LeetCode95 {

    /**
     * 解题思路： 就是将任何一个i作为根节点，递归构造左子树和右子树，然后将这些树构建起来
     */

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateSubTree(1, n);
    }

    private List<TreeNode> generateSubTree(int start, int end) {
        List<TreeNode> resultNode = new ArrayList<>();

        if (start > end) {
            resultNode.add(null);
            return resultNode;
        }

        for (int i = start; i <= end; i++) {
             // 构造所有的左子树
            List<TreeNode> leftTreed = generateSubTree(start, i - 1);
            // 构造所有的右子树
            List<TreeNode> rightTree = generateSubTree(i + 1, end);

            // 将左右子树进行结合，构造二叉树
            for (TreeNode leftNode : leftTreed) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = leftNode;
                    currentNode.right = rightNode;
                    resultNode.add(currentNode);
                }
            }
        }
        return resultNode;
    }

    public static void main(String[] args) {
        LeetCode95 solution = new LeetCode95();
        List<TreeNode> trees = solution.generateTrees(3);
        System.out.println("Generated " + trees.size() + " unique BSTs.");
        trees.forEach(p ->{
            System.out.println(new LeetCode94().inorderTraversal(p));
        });
    }
}
