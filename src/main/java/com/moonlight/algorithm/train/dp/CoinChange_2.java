package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/coin-change-2/
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5    5=2+2+1     5=2+1+1+1    5=1+1+1+1+1
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 *
 * @author Moonlight
 * @date 2021/1/6 16:02
 */
public class CoinChange_2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int[] arr222 = {2};
        System.out.println(change(5, arr));
        System.out.println(change(3, arr222));

        System.out.println(change2222(5, arr));
        System.out.println(change2222(3, arr222));

        System.out.println(dp(5, arr));
        System.out.println(dp(3, arr222));
    }

    public static int change(int amount, int[] coins) {
        if ((coins == null || coins.length == 0)) {
            return amount <= 0 ? 1 : 0;
        }
        return process(coins, 0, amount);
    }

    private static int process(int[] coins, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i * coins[index] <= rest; i++) {
            count += process(coins, index + 1, rest - (i * coins[index]));
        }
        return count;
    }

    public static int change2222(int amount, int[] coins) {
        if ((coins == null || coins.length == 0)) {
            return amount <= 0 ? 1 : 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return process2222(coins, 0, amount, dp);
    }

    private static int process2222(int[] coins, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == coins.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        int count = 0;
        for (int i = 0; i * coins[index] <= rest; i++) {
            count += process2222(coins, index + 1, rest - (i * coins[index]), dp);
        }
        dp[index][rest] = count;
        return dp[index][rest];
    }

    public static int dp(int amount, int[] coins) {
        if ((coins == null || coins.length == 0)) {
            return amount <= 0 ? 1 : 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[coins.length][0] = 1;

        int count;
        for (int index = coins.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= amount ; rest++) {
                count = 0;
                for (int i = 0; i * coins[index] <= rest; i++) {
                    count += dp[index + 1][rest - (i * coins[index])];
                }
                dp[index][rest] = count;
            }
        }

        return dp[0][amount];
    }

}
