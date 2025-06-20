package com.chen.algor.arrays.greedy;

/**
 * 题目描述
 * n个孩子站成一排，给你一个整数数组，rating表示每个孩子得分，
 * 按照以下要求进行分发糖果，
 * 1 每个孩子至少得到一个糖果
 * 2 相邻两个孩子评分高的孩子会得到更多的糖果
 */
public class LeetCode135 {

    /**
     * 解题思路
     * 1 使用贪心算法，分别从左，从右进行遍历，然后计算数组的最大值
     * @param rating
     * @return
     */
    public int candy(int[] rating) {

        int[] candies =new int[rating.length];

        int n = rating.length;
        for (int i = 0; i < rating.length ; i++) {
               candies[i] = 1;
        }

        // 从左向右进行便利
        for (int i = 1; i < rating.length; i++) {
            if(rating[i] > rating[i-1]){
                 candies[i] = candies[i-1] + 1;
            }
        }

        // 从右想左进行遍历
        for (int i = n-2 ; i >=0 ; i--) {
              if(rating[i] > rating[i+1]){
                  candies[i] = Math.max(candies[i], candies[i + 1] + 1);
              }
        }
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode135().candy(new int[]{1,3,4,5,2}));
    }
}
