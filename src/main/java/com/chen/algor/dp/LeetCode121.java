package com.chen.algor.dp;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。0
 * 举例： 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
   注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class LeetCode121 {

    /**
     * 想复杂了，咯咯
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
             return 0;
        }

        Integer minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;  // 初始化最大利润
        for (int i = 0; i < prices.length; i++) {
            // 这里控制顺序，控制是不是可以减
            if (prices[i] < minPrice) {
                  minPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(new LeetCode121().maxProfit(prices));
    }
}
