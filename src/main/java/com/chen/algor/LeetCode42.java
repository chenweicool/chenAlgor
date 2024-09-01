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

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(new LeetCode42().trap(height));
    }

}
