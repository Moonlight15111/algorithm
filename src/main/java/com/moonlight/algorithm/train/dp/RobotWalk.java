package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 1. 分析是否有重复求解  2.  找出参数长度范围   3. 分析表结构   4. 建表，初始化
 * @ClassName RobotWalk
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/12/31 20:53
 * @Version V1.0
 **/
public class RobotWalk {

    public static void main(String[] args) {
        System.out.println(walk(5, 2, 4, 6));
        System.out.println(walk222(5, 2, 4, 6));
    }

//    public static int walk333(int n, int start, int aim, int k) {
//
//    }

    public static int walk222(int n, int start, int aim, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
       return process2222(start, k, aim, n, dp);
    }

    private static int process2222(int cur, int rest, int aim, int n, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == aim ? 1 : 0;
            return dp[cur][rest];
        }
        if (cur == 1) {
            dp[cur][rest] = process2222(2, rest - 1, aim, n, dp);
            return dp[cur][rest];
        }
        if (cur == n) {
            dp[cur][rest] = process2222(n - 1, rest - 1, aim, n, dp);
            return dp[cur][rest];
        }
        dp[cur][rest] = process2222(cur - 1, rest - 1, aim, n, dp) + process2222(cur + 1, rest - 1, aim, n, dp);
        return dp[cur][rest];
    }

    // n: 有多少个位置 start：机器人开始所在的位置  aim: 目标位置   k：走多少步
    public static int walk(int n, int start, int aim, int k) {
        return process(start, k, aim, n);
    }

    // cur: 机器人当前所在的位置   rest：还剩下多少步   aim: 目标位置   n：有多少个位置
    private static int process(int cur, int rest, int aim, int n) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process(2, rest - 1, aim, n);
        }
        if (cur == n) {
            return process(n - 1, rest - 1, aim, n);
        }
        return process(cur - 1, rest - 1, aim, n) + process(cur + 1, rest - 1, aim, n);
    }

}
