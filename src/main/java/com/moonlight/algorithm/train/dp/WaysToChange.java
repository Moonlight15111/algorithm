package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/coin-lcci/
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 输入: n = 5    输出：2
 * 解释: 有两种方式可以凑成总金额:  5 = 5     5 = 1 + 1 + 1 + 1 + 1
 *
 * 输入: n = 10   输出：4
 * 解释: 有四种方式可以凑成总金额:  10 = 10   10 = 5 + 5    10 = 5 + 1 + 1 + 1 + 1 + 1
 *                                  10 = 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1
 *
 * @author Moonlight
 * @date 2021/1/6 17:50
 */
public class WaysToChange {

    public static void main(String[] args) {
        System.out.println(waysToChange(5));
        System.out.println(waysToChange(10));
//        System.out.println(waysToChange(900750));

        System.out.println(waysToChange222(5));
        System.out.println(waysToChange222(10));
//        System.out.println(waysToChange222(900750));

        System.out.println(waysToChange333(5));
        System.out.println(waysToChange333(10));
        System.out.println(waysToChange333(900750));
    }

    public static int waysToChange(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = {1, 5, 10, 25};
        return process(arr, 0, n);
    }

    private static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i * arr[index] <= rest; i++) {
            count += process(arr, index + 1, rest - (i * arr[index]));
        }
        return count;
    }

    public static int waysToChange222(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = {1, 5, 10, 25};
        int[][] dp = new int[arr.length + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return process222(arr, 0, n, dp);
    }

    private static int process222(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        int count = 0;
        for (int i = 0; i * arr[index] <= rest; i++) {
            count += process222(arr, index + 1, rest - (i * arr[index]), dp);
        }
        dp[index][rest] = count;
        return dp[index][rest];
    }

    public static int waysToChange333(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = {1, 5, 10, 25};
        int[][] dp = new int[arr.length + 1][n + 1];
        dp[arr.length][0] = 1;
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= n; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] = (dp[index][rest] + dp[index][rest - arr[index]]) % 1000000007;
                }
            }
        }
        return dp[0][n];
    }

}
