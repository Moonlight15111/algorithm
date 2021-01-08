package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/minimum-path-sum/
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]    输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 输入：grid = [[1,2,3],[4,5,6]]     输出：12
 *
 * @author Moonlight
 * @date 2021/1/7 17:00
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};

        int[][] grid22 = new int[2][3];
        grid22[0] = new int[]{1, 2, 3};
        grid22[1] = new int[]{4, 5, 6};

        System.out.println(minPathSum(grid));
        System.out.println(minPathSum(grid22));

        System.out.println(minPathSum222(grid));
        System.out.println(minPathSum222(grid22));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        return process(grid, 0, 0);
    }

    private static int process(int[][] grid, int x, int y) {
        int count = 0;
        if (x == grid[0].length) {
            for (int i = y + 1; i < grid.length;i++) {
                count += grid[i][x - 1];
            }
            return count;
        }
        if (y == grid.length) {
            for (int i = x + 1; i < grid[y - 1].length; i++) {
                count += grid[y - 1][i];
            }
            return count;
        }
        count = grid[y][x] + Math.min(process(grid, x + 1, y), process(grid, x, y + 1));
        return count;
    }

    public static int minPathSum222(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return process222(grid, 0, 0, dp);
    }

    private static int process222(int[][] grid, int x, int y, int[][] dp) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        int count = 0;
        if (x == grid[0].length) {
            for (int i = y + 1; i < grid.length;i++) {
                count += grid[i][x - 1];
            }
            dp[y][x] = count;
            return dp[y][x];
        }
        if (y == grid.length) {
            for (int i = x + 1; i < grid[y - 1].length; i++) {
                count += grid[y - 1][i];
            }
            dp[y][x] = count;
            return dp[y][x];
        }
        dp[y][x] = grid[y][x] + Math.min(process222(grid, x + 1, y, dp), process222(grid, x, y + 1, dp));
        return  dp[y][x];
    }

}
