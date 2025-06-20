package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后续遍历
 */
public class LeetCode145 {

    // 递归的实现
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        reverse(root,result);
        return result;
    }

    // 使用栈来实现
    public List<Integer> V2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        // 对栈进行遍历
        while(!output.isEmpty()){
             result.add(output.pop().val);
        }
        return result;
    }

    public void reverse(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        reverse(root.left,result);
        reverse(root.right,result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        LeetCode145  solution = new LeetCode145();
        List<Integer> result = solution.postorderTraversal(root);
        List<Integer> result2 = solution.V2(root);
        System.out.println(result); // 输
        System.out.println(result2);
    }
}
