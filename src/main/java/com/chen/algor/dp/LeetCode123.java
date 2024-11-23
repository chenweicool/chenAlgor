package com.chen.algor.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        // 分为从左到右，然后从右到左，
        int[] priceLeft = new int[n];
        int[] priceRight = new int[n];

        int minPrices = prices[0];
        // 计算从左到右一次交易的最大数额
        for (int i = 1; i < n; i++) {
                priceLeft[i] = Math.max(priceLeft[i-1], prices[i] - minPrices);
                minPrices = Math.min(minPrices, prices[i]);
        }

        // 计算从右到左的交易的最大数额
        int maxRight = prices[n - 1];
        for (int i = n-2; i >= 0; i--){
            priceRight[i] = Math.max(priceRight[i + 1], maxRight - prices[i]);
            maxRight = Math.max(maxRight, prices[i]);
        }

        // 获取今天最大数值
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, priceLeft[i] + priceRight[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
