package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * 输入：cost = [10, 15, 20]   输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 *
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]    输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *
 * @author Moonlight
 * @date 2021/1/12 17:58
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] arr = {10, 15, 20};
        int[] arr22 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(arr));
        System.out.println(minCostClimbingStairs(arr22));
        System.out.println(minCostClimbingStairs222(arr));
        System.out.println(minCostClimbingStairs222(arr22));
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int a = Math.min(process(cost, 0, 1), process(cost, 0, 2));
        int b = Math.min(process(cost, 1, 1), process(cost, 1, 2));
        return Math.min(a, b);
    }

    private static int process(int[] cost, int start, int step) {
        if (start >= cost.length) {
            return 0;
        }
        int one = process(cost, start + step, 1);
        int two = process(cost, start + step, 2);
        return cost[start] + Math.min(one, two);
    }

    public static int minCostClimbingStairs222(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[][] dp = new int[cost.length + 2][3];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        int a = Math.min(process222(cost, 0, 1, dp), process222(cost, 0, 2, dp));
        int b = Math.min(process222(cost, 1, 1, dp), process222(cost, 1, 2, dp));
        return Math.min(a, b);
    }

    private static int process222(int[] cost, int start, int step, int[][] dp) {
        if (dp[start][step] != -1) {
            return dp[start][step];
        }
        if (start >= cost.length) {
            dp[start][step] = 0;
            return dp[start][step];
        }
        int one = process222(cost, start + step, 1, dp);
        int two = process222(cost, start + step, 2, dp);
        dp[start][step] = cost[start] + Math.min(one, two);
        return dp[start][step];
    }

}
