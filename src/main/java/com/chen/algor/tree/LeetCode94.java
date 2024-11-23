package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *二叉树的中序遍历
 * 二叉树的中序遍历
 */
public class LeetCode94 {

    /**
     * 进行迭代处理
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            // 将左子树入栈
            while(root != null){
                stack.push(root);
                root = root.left; // 移动到左节点
            }

            root =  stack.pop();
            result.add(root.val);
            root = root.right;  // 移动到右节点
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
