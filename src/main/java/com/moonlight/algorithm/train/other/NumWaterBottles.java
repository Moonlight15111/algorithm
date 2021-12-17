package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/water-bottles/
 *
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 *
 * 输入：numBottles = 9, numExchange = 3  输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 *       所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 *
 * 输入：numBottles = 15, numExchange = 4  输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 *
 * 输入：numBottles = 5, numExchange = 5  输出：6
 *
 * 输入：numBottles = 2, numExchange = 3  输出：2
 *
 * @author Moonlight<bzeng @ ibingli.com>
 * @date 2021-12-17 10:47
 */
public class NumWaterBottles {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
        System.out.println(numWaterBottles(15, 4));
        System.out.println(numWaterBottles(5, 5));
        System.out.println(numWaterBottles(2, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        }
        int ans = numBottles, d;

        while (numBottles >= numExchange) {
            d = numBottles % numExchange;
            numBottles /= numExchange;
            ans += numBottles;
            numBottles += d;
        }

        return ans;
    }

}
