package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * arr是货币数组，其中的值都是正数。再给定一个正数aim。
 * 每个值都认为是一张货币，
 * 即便是值相同的货币也认为每一张都是不同的，
 * 返回组成aim的方法数
 * 例如：arr = {1,1,1}，aim = 2
 * 第0个和第1个能组成2，第1个和第2个能组成2，第0个和第2个能组成2
 * 一共就3种方法，所以返回3
 *
 * @ClassName CoinsWay_2
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/5 21:45
 * @Version V1.0
 **/
public class CoinsWay_1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 1};
        System.out.println(coinsWay(arr, 4));
        System.out.println(coinsWay1(arr, 4));
        System.out.println(dpWay(arr, 4));

        int[] arr222 = {1, 1, 1};
        System.out.println(coinsWay(arr222, 2));
        System.out.println(coinsWay1(arr222, 2));
        System.out.println(dpWay(arr222, 2));
    }

    public static int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        // 每个位置上的硬币都有两个方向，拿 或者 不拿
        int take = 0;
        if (rest - arr[index] >= 0) {
            take += process(arr, index + 1, rest - arr[index]);
        }
        int notTake = process(arr, index + 1, rest);
        return take + notTake;
    }

    public static int coinsWay1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return process1(arr, 0, aim, dp);
    }

    private static int process1(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        // 每个位置上的硬币都有两个方向，拿 或者 不拿
        int take = 0;
        if (rest - arr[index] >= 0) {
            take += process(arr, index + 1, rest - arr[index]);
        }
        int notTake = process1(arr, index + 1, rest, dp);
        dp[index][rest] = take + notTake;
        return dp[index][rest];
    }

    public static int dpWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int len = arr.length;
        int[][] dp = new int[len + 1][aim + 1];
        dp[len][0] = 1;

        for (int index = len - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int take = 0;
                if (rest - arr[index] >= 0) {
                    take += dp[index + 1][rest - arr[index]];
                }
                int notTake = dp[index + 1][rest];
                dp[index][rest] = take + notTake;
            }
        }

        return dp[0][aim];
    }

}
