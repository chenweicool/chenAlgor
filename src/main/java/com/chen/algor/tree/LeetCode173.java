package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root
 * 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 */
public class LeetCode173 {


    class BSTIterator {

      private  Stack<TreeNode> stack;

      public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeftStack(root); // 初始化将所有左子树压入到栈中
        }

        public int next() {
            TreeNode pop = stack.pop();
            if (pop != null) {
                 pushLeftStack(pop.right);
            }
            return pop.val;
        }

        private void pushLeftStack(TreeNode right) {
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(20);
        LeetCode173 leetCode173 = new LeetCode173();
        System.out.println();
    }
}
