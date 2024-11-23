package com.chen.algor.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 */
public class LeetCode93 {

    /**
     * 生成ip地址
     */
    public List<String> generateIpAddress(String s) {
        List<String> result = new ArrayList<>();
        // 使用回溯法
        backtrack(result, s, 0, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String s, int index, String curr, int sage) {

        // 声明边界条件
        if (sage == 4 && index == s.length()) {
            result.add(curr);
            return;
        }
        if (sage > 4 || index == s.length()) {
            return;
        }

        // 尝试分割字符串为三串
        for (int len = 1; len <= 3;  len++) {

            if (index + len > s.length()) {
                 return;
            }

            // 尝试分割1到3个ip地址段
            String part = s.substring(index, index + len);
            // 检查有效性
            if (isValate(part)) {
                backtrack(result, s, index + len, sage == 0 ? part : curr + "." + part, sage + 1);
            }
        }
    }

    private boolean isValate(String part) {

        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }
        int ip = Integer.parseInt(part);
        return ip >= 0 && ip <= 255;
    }

    public static void main(String[] args) {
        String s = "25225511121";

        System.out.println(new LeetCode93().generateIpAddress(s));
    }
}
