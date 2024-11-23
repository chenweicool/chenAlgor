package com.chen.algor.dp;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * 知道这个问题怎么解决
 * 举例：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
 * 最大总利润为 4 + 3 = 7 。
 */
public class LeetCode122 {

    /**
     * 我们只需要关注每天的差价，prices[i] - price[i-1]
     * 如果当天的价格比昨天的高，就累加到利润中去
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
         int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        LeetCode122 solution = new LeetCode122();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("最大利润: " + solution.maxProfit(prices)); // 输出：7
    }
}
