package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 *        1.  1 阶 + 1 阶       2.  2 阶
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author Moonlight
 * @date 2021/1/6 10:39
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));

        System.out.println(climbStairsCache(2));
        System.out.println(climbStairsCache(3));

        System.out.println(dp(2));
        System.out.println(dp(3));

        System.out.println(dp222(2));
        System.out.println(dp222(3));
    }

    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        return process(n);
    }

    private static int process(int rest) {
        if (rest == 0) {
            return 1;
        }
        // 还有2步走，那就走2步试试
        int twoStep = 0;
        if (rest >= 2) {
            twoStep = process(rest - 2);
        }
        return process(rest - 1) + twoStep;
    }

    public static int climbStairsCache(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return processCache(n, dp);
    }

    private static int processCache(int rest, int[] dp) {
        if (dp[rest] != -1) {
            return dp[rest];
        }
        if (rest == 0) {
            dp[rest] = 1;
            return dp[rest];
        }
        int twoStep = 0;
        if (rest >= 2) {
            twoStep = processCache(rest - 2, dp);
        }
        dp[rest] = processCache(rest - 1, dp) + twoStep;
        return dp[rest];
    }

    public static int dp(int n) {
        if (n  <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int index = 1; index <= n; index++) {
            dp[index] = dp[index - 1];
            if (index >= 2) {
                dp[index] += dp[index - 2];
            }
        }

        return dp[n];
    }

    public static int dp222(int n) {
        if (n  <= 0) {
            return 0;
        }
        // index 位置只与 index - 1  index - 2 两个有关
        int cur = 0, prev = 0, tol = 1;
        for (int index = 0; index < n; index++) {
            prev = cur;
            cur = tol;
            tol = prev + cur;
        }

        return tol;
    }

}
