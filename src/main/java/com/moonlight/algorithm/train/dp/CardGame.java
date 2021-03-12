package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * N张牌,每次可以出1张、3张或者5张,请问出完这N张牌,有多少种出法?
 * @author Moonlight
 * @date 2021/3/12 16:01
 */
public class CardGame {

    public static void main(String[] args) {
        System.out.println(stepWay(17) + ", " + stepWay22(17) + ", " + stepWay333(17));
    }

    public static int stepWay(int n) {
        if (n < 1) {
            return 0;
        }
        int[] arr = {1, 3, 5};
        return process(arr, 0, n);
    }

    private static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i * arr[index] <= rest ; i++) {
            count += process(arr, index + 1, rest - (i * arr[index]));
        }
        return count;
    }

    public static int stepWay22(int n) {
        if (n < 1) {
            return 0;
        }
        int[] arr = {1, 3, 5};
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
            dp[index][rest] = (rest == 0 ? 1 : 0);
            return dp[index][rest];
        }
        int count = 0;
        for (int i = 0; i * arr[index] <= rest ; i++) {
            count += process222(arr, index + 1, rest - (i * arr[index]), dp);
        }
        dp[index][rest] = count;
        return dp[index][rest];
    }

    public static int stepWay333(int n) {
        if (n < 1) {
            return 0;
        }
        int[] arr = {1, 3, 5};
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
