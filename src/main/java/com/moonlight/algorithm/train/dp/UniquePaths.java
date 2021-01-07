package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 7, n = 3   输出：28
 *
 * 输入：m = 3, n = 2   输出：3
 *
 * 输入：m = 3, n = 3   输出：6
 *
 * @author Moonlight
 * @date 2021/1/7 15:57
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(3, 3));

        System.out.println(uniquePaths222(7, 3));
        System.out.println(uniquePaths222(3, 2));
        System.out.println(uniquePaths222(3, 3));

        System.out.println(dp(7, 3));
        System.out.println(dp(3, 2));
        System.out.println(dp(3, 3));
    }

    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        return process(m, n, 1, 1);
    }

    private static int process(int m, int n, int x, int y) {
        if (x == m || y == n) {
            return 1;
        }
        return process(m, n, x + 1, y) + process(m, n, x, y + 1);
    }

    public static int uniquePaths222(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        return process222(m, n, 1, 1, dp);
    }

    private static int process222(int m, int n, int x, int y, int[][] dp) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        if (x == m || y == n) {
            dp[x][y] = 1;
            return dp[x][y];
        }
        dp[x][y] = process222(m, n, x + 1, y, dp) + process222(m, n, x, y + 1, dp);
        return dp[x][y];
    }

    public static int dp(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[m][i] = 1;
        }

        for (int x = m - 1; x >= 1; x--) {
            for (int y = n -1; y >= 1; y--) {
                dp[x][y] = dp[x + 1][y] + dp[x][y + 1];
            }
        }

        return dp[1][1];
    }

}
