package com.chen.algor.string;

import com.chen.algor.arrays.LeetCode36;

/**
 * 外观数列
 * 要求： 「外观数列」是一个数位字符串序列，由递归公式定义：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
 * 行程长度编码（RLE）是一种字符串压缩方法，
 * 其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。
 * 例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。
 * 因此压缩后字符串变为 "23321511"。
 *
 * 给定一个整数 n ，返回 外观数列 的第 n 个元素。
 */
public class LeetCode38 {

    public String GenerateString(int n) {
        if (n <= 0) {
            return "";
        }
        // 初始值
        String result = "1";

        // 遍历n，然后进行生成字符串
        for (int i = 1; i < n; i++) {
            result = generateNextString(result);
        }
        return result;
    }

    /**
     * 生成下一个具体值的方法
     * @param result
     * @return
     */
    private String generateNextString(String result) {
        StringBuilder nextSequence = new StringBuilder();

        int count = 1;
        // 获取它的上一个元素
        char previours = result.charAt(0);

        for (int i = 1; i < result.length(); i++) {
            char currentChar = result.charAt(i);
            // 计算相等的数量
            if (currentChar == previours) {
                count++;
            }else{
                // 计算第一次出现的数量
                nextSequence.append(count).append(previours);
                count = 1;
                previours = currentChar;
            }
        }
        return nextSequence.append(count).append(previours).toString();
    }

    public static void main(String[] args) {
        String s = new LeetCode38().GenerateString(4);
        System.out.println(s);
    }
}
