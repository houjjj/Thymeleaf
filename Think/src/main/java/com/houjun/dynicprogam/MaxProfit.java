package com.houjun.dynicprogam;

/**
 * 121.买卖股票的最近时机
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] profit = {7, 1, 5, 3, 6, 4};
        int result = maxProfit2(profit);
        System.out.println(result);
    }

    /**
     * 解法二：暴力破解
     *
     * @param profit
     * @return
     */
    private static int maxProfit2(int[] profit) {
        int max = 0;
        for (int i = 0; i < profit.length; i++) {
            for (int j = i; j < profit.length; j++) {
                int buy = profit[i];
                int sell = profit[j];
                max = Math.max(max, sell - buy);
            }
        }
        return max;
    }


    /**
     * 解法一：动态规划
     * 一个变量minPrices表示从开始到第n天，股票的最低价格
     * 一个变量max 表示最大利润，今天最大利润需要用昨天的最大利润和今天卖的利润【今天股票价格减去股票的最低价格】对比
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrices = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // 到目前为止的最小值
            minPrices = Math.min(minPrices, prices[i]);
            // 今天的最大利润= 【昨天的最大利润 或者是 今天的最新价格-最低股票价格】
            max = Math.max(max, prices[i] - minPrices);
        }
        return max;
    }
}
