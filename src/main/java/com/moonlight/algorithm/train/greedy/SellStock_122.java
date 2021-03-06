package com.moonlight.algorithm.train.greedy;

/**
 * 〈给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * @ClassName SellStock_122
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/9/13 15:03
 * @Version V1.0
 **/
public class SellStock_122 {

    public static void main(String[] args) {
        int[] case1 = {7,1,5,3,6,4};
        int[] case2 = {1,2,3,4,5};
        System.out.println(maxProfit(case1));
        System.out.println(maxProfit(case2));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int res = 0;

        for (int i = 1, length = prices.length; i < length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }

        return res;
    }

}
