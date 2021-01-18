package com.moonlight.algorithm.train.dp;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/coin-change/
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 输入：coins = [1, 2, 5], amount = 11    输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 输入：coins = [2], amount = 3   输出：-1
 *
 * @author Moonlight
 * @date 2021/1/18 16:41
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] arr = {1, 2147483647};
        System.out.println(coinChange(arr, 2));
        System.out.println(coinChange222(arr, 2));
        System.out.println(dp(arr, 2));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return amount <= 0 ? 1 : 0;
        }
        if (amount <= 0) {
            return 0;
        }
        int val = process(coins, 0, amount);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    private static int process(int[] coins, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (rest <= 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE, tmp;
        for (int i = 0; i * coins[index] <= rest ; i++) {
            tmp = process(coins, index + 1, rest - (i * coins[index]));
            if (tmp != Integer.MAX_VALUE) {
                min = Math.min(tmp + i, min);
            }
        }
        return min;
    }

    public static int coinChange222(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return amount <= 0 ? 1 : 0;
        }
        if (amount <= 0) {
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        int val = process222(coins, 0, amount, dp);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    private static int process222(int[] coins, int index, int rest, int[][] dp) {
        if (index == coins.length) {
            dp[index][rest] = rest == 0 ? 0 : Integer.MAX_VALUE;
            return dp[index][rest];
        }
        if (rest <= 0) {
            dp[index][rest] = 0;
            return dp[index][rest];
        }
        int min = Integer.MAX_VALUE, tmp;
        for (int i = 0; i * coins[index] <= rest ; i++) {
            tmp = process222(coins, index + 1, rest - (i * coins[index]), dp);
            if (tmp != Integer.MAX_VALUE) {
                min = Math.min(tmp + i, min);
            }
        }
        dp[index][rest] = min;
        return dp[index][rest];
    }

    public static int dp(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return amount <= 0 ? 1 : 0;
        }
        if (amount <= 0) {
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i <= amount ; i++) {
            dp[coins.length][i] = Integer.MAX_VALUE;
        }

        for (int index = coins.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= amount; rest++) {
                int min = Integer.MAX_VALUE, tmp;

                for (int i = 0; i * coins[index] <= rest; i++) {
                    tmp = dp[index + 1][rest - (i * coins[index])];
                    if (tmp != Integer.MAX_VALUE) {
                        min = Math.min(tmp + i, min);
                    }
                }
                dp[index][rest] = min;

            }
        }
        return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
    }

}
