package com.chen.algor.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LeetCode8 {

    // 优先状态机来解决这个问题
    class Amato{
        public int sign = 1;
        public long ans = 0;

        private String state = "start";

        // 初始化表格数据
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};
        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    class Solution{
        public int myAtoi(String str) {
            Amato automaton = new Amato();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                automaton.get(str.charAt(i));
            }
            return (int) (automaton.sign * automaton.ans);
        }

    }

    /**
     * chatGPT的解答
     * 以一个i为变量
     * 边界条件就是:
     * 最大和最小的正整数
     * 1 判断为空，确定一个下标值
     * 2 判断+ -符号
     * 3 解析数字，然后确认边界
     * @param s
     * @return
     */
    public int myAtoiChatGpt(String s) {
        // Constants for 32-bit signed integer range
        final int INT_MAX = 2147483647;
        final int INT_MIN = -2147483648;
         // 去除空格
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
               i++;
        }
        // todo 这里正负号的判断
        // -+ 12  +1 就不能通过
        int sign = 1;
        while (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+') ) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
            break;
        }
        // 判断数字
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) ;
            digit = digit -'0';
            if (num > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

    public static void main(String[] args) {
       String str = "-12";
        int i = new LeetCode8().myAtoiChatGpt(str);
        System.out.println(i);
    }
}
