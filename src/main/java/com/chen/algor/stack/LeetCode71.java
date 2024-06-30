package com.chen.algor.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetCode的第71题，
 * 简化路径
 */
public class LeetCode71 {
    /**
     * 使用栈来解决
     * 1 先使用/将字符串进行分割，
     * 2 然后判断，如果是空或者 当前目录直接跳过，
     * 3 如果是上一级目录符号，且栈不为空，弹出栈顶元素
     * 3  返回该有元素
     * @param path
     * @return
     */
    public String simplyPath(String path) {
        Deque<String> stack = new LinkedList<>();

        String[] component = path.split("/");
        // 遍历字符串
        for (String s : component) {
                if(s.isEmpty() || s.equals(".")){
                    continue;
                }
                if(s.equals("..")){
                    if (!stack.isEmpty()) {
                          stack.pop();
                    }
                }else{
                    stack.push(s);
                }
        }

        StringBuilder result = new StringBuilder();
        // 构造最短路径的值
        for (String s : stack) {
            result.insert(0, "/" + s);
        }
        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        String path = "/../";
        System.out.println("simply path is " + new LeetCode71().simplyPath(path));
    }
}
