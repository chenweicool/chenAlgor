package com.chen.algor.arrays;

import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 声明hashSet
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int maxLength = 0;
        for (Integer num : hashSet) {
            // 确认起点，这个很重要，确认完起点之后，
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                // 遍历确认起点，然后依次寻找
                while (hashSet.contains(currentNum + 1)) {
                     currentNum++;
                     currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 输出: 4
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 输出: 9
    }
}
