package com.chen.algor.tree;

import com.chen.algor.common.TreeNode;
import org.apache.commons.text.translate.UnicodeUnescaper;

import javax.xml.soap.SAAJMetaFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class LeetCode144 {

    // 递归的方法实现，
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preReverse(root, result);
        return result;
    }
    private void preReverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preReverse(root.left, result);
        preReverse(root.right, result);
    }

    // 第二种方式使用栈来实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            // 先压右子树
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

       LeetCode144  solution = new LeetCode144();
        List<Integer> result = solution.preorderTraversal(root);
        List<Integer> result2 = solution.inorderTraversal(root);
        System.out.println(result); // 输
        System.out.println(result2);
    }
}
