package com.chen.algor.string;

/**
 * 给定一个字符串 s ，返回 s 是否是一个 有效数字。
 *
 * 例如，下面的都是有效数字："2", "0089", "-0.1", "+3.14",
 * "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"，
 * 而接下来的不是："abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"。
 *
 * 一般的，一个 有效数字 可以用以下的规则之一定义：
 *
 * 一个 整数 后面跟着一个 可选指数。
 * 一个 十进制数 后面跟着一个 可选指数。
 * 一个 整数 定义为一个 可选符号 '-' 或 '+' 后面跟着 数字。
 * 一个 十进制数 定义为一个 可选符号 '-' 或 '+' 后面跟着下述规则：
 * 数字 后跟着一个 小数点 .。
 * 数字 后跟着一个 小数点 . 再跟着 数位。
 * 一个 小数点 . 后跟着 数位。
 */
public class LeetCode65 {
    /**
     * 字符串匹配
     * 原始解决方法
     * @param s
     * @return
     */
    public static  boolean isMatch(String s) {
         // 去除前后空格
          s = s.trim();

        if (s.isEmpty()) {
            return false;
        }
        // 声明是否有数组，有字符串，有指数
        boolean hasNum = false;
        boolean hasDot = false;
        boolean hasE = false;

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                 hasNum = true;
            } else if (c == '.') {
                // 因为小数点只能出现一次并且不能出现在指数部分
                 if(hasDot || hasE){
                     return false;
                 }
                 hasDot = true;
            } else if (c == 'e' || c == 'E') {
                // 指数只能出现一次，并且前面只能是数字
                if (hasE || !hasNum) {
                     return false;
                }
                hasE = true;
                hasNum = false;  // 重置数字，指数后面必须要有数字
            } else if (c == '+' || c == '-') {
                // 符号只能出现最开头，或者指数后面
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                      return false;
                }
            }else{
                return false;
            }
        }
        // 返回数字
        return hasNum;
    }

    // 正则表达式进行匹配，比较简单
    public static  boolean isMatchV2(String s){
        // 定义正则表达式
        String regex = "^[+-]?((\\d+\\.?\\d*)|(\\.\\d+))(e[+-]?\\d+)?$";

        // 去除前后空格
        s = s.trim();

        // 判断是否匹配正则表达式
        return s.matches(regex);
    };

    public static void main(String[] args) {
        String s = "345_e.23";
        System.out.println(isMatch(s));
    }
}
