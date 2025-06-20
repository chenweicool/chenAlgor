package com.chen.algor;

/**
 * 著名的接雨水问题
 */
public class LeetCode42 {

    /**
     * 使用双指针
     * 1  声明左右指针
     * 2  遍历指针进行判断
     * 关键声明左右的最大和最小的数，然后以此判断
     * 雨水的能不能乘的下关键在于: 两边比较的最大值
     * 临界点，只是当左侧有比当前高度小的水珠，才可以接水，这个很重要
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        // 声明两个指针
        int left = 0 ,
                right = height.length-1,
                leftMax = 0,
                rightMax = 0,
                totalWater = 0;

        // 遍历数组
        while (left <right){
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }else{
                    totalWater += leftMax - height[left];
                }
                left++;
            }else{
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }else{
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    // 使用动态规划来解决
    // 声明两个数组，分别存储每个位置左侧和右侧的最大高度，left_max[] 和 right_max[]
    // 对于每个位置计算： 对每个位置，计算 min(left_max[i], right_max[i]) - height[i] 来得到该位置能够存储的水量。
    public int trapV2(int[] height) {
        int n = height.length;
        // 声明两个数组，来分别存储左侧每个位置最左测和最右侧最大高度
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        int result = 0;
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[n-1] = height[n - 1];
        for (int i = n-2; i >= 0 ; i--) {
            right_max[i]  = Math.max(right_max[i + 1], height[i]);
        }

        // 计算每个位点最大值
        for (int i = 0; i <n ; i++) {
            result += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(new LeetCode42().trap(height));
        System.out.println(new LeetCode42().trapV2(height));
    }

}
