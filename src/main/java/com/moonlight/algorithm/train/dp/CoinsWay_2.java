package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * arr是面值数组，其中的值都是正数且没有重复。再给定一个正数aim。
 * 每个值都认为是一种面值，且认为张数是无限的。
 * 返回组成aim的方法数
 * 例如：arr = {1,2}，aim = 4
 * 方法如下：1+1+1+1、1+1+2、2+2
 * 一共就3种方法，所以返回3
 *
 * @ClassName CoinsWay
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/5 20:26
 * @Version V1.0
 **/
public class CoinsWay_2 {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(coinsWay1(arr, 4));
        System.out.println(coinsWay2(arr, 4));
        System.out.println(coinsWay3(arr, 4));
        System.out.println(coinsWay4(arr, 4));
    }

    public static int coinsWay1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int rest) {
        if (rest < 0) {
            return 0;
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        // 暴力递归 ==》 记忆化搜索(自顶向下的动态规划，其实就是加个缓存表把已经算过的扔表里，数据并没有组织起来)  ==》 动态规划（组织数据,状态转移）
        // 先尝试出暴力递归过程，分析是否有重复求解，分析可变参数及参数变化范围(根据base case或边界条件找参数变化范围)，封装可变参数建立缓存表，对表进行初始化
        // f(index, rest) 自由使用arr[index]及其往后所有的硬币，搞定rest这么多钱，有多少种方法
        int count = 0;
        // 使用 i 个 arr[index]的硬币
        for (int i = 0; i * arr[index] <= rest; i++) {
            count += process1(arr, index + 1, rest - (i * arr[index]));
        }
        return count;
    }

    public static int coinsWay2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];

        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }

        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        // 自由使用arr[index]及其往后所有的硬币，搞定rest这么多钱，有多少种方法
        int count = 0;
        // 使用 i 个 arr[index]的硬币
        for (int i = 0; i * arr[index] <= rest; i++) {
            count += process2(arr, index + 1, rest - (i * arr[index]), dp);
        }
        dp[index][rest] = count;
        return dp[index][rest];
    }

    public static int coinsWay3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int len = arr.length;
        int[][] dp = new int[len + 1][aim + 1];
        // index == arr.length ==> rest == 0 ? 1 : 0
        dp[len][0] = 1;
        // 每个index位置都依赖index + 1位置的值
        for (int index = len - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int count = 0;
                for (int i = 0; i * arr[index] <= rest; i++) {
                    count += dp[index + 1][rest - (i * arr[index])];
                }
                dp[index][rest] = count;
            }
        }
        return dp[0][aim];
    }

    public static int coinsWay4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int len = arr.length;
        int[][] dp = new int[len + 1][aim + 1];
        // index == arr.length ==> rest == 0 ? 1 : 0
        dp[len][0] = 1;
        // 每个index位置都依赖index + 1位置的值
        // rest - (i * arr[index])
        for (int index = len - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

}
