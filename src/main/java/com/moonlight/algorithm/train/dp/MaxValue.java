package com.moonlight.algorithm.train.dp;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 */
public class MaxValue {

    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }, b = {
                {1, 3, 10}, {2, 2, 3}, {7, 3, 8}
        };
        System.out.println(backtrack(a) + ", " + cache(a) + ", " + dp(a));
        System.out.println(backtrack(b) + ", " + cache(b) + ", " + dp(b));
    }

    public static int dp(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = grid[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[r][c];
    }

    public static int cache(int[][] grid) {
        int[][] c = new int[grid.length][grid[0].length];
        return recursion(grid.length - 1, grid[0].length - 1, grid, c);
    }

    private static int recursion(int r, int c, int[][] grid, int[][] cache) {
        if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0) {
            return 0;
        }
        if (cache[r][c] != 0) {
            return cache[r][c];
        }
        if (r == 0 && c == 0) {
            cache[r][c] = grid[r][c];
        } else if (r == 0 && c == 1) {
            cache[r][c] = grid[0][0] + grid[0][1];
        } else if (r == 1 && c == 0) {
            cache[r][c] = grid[0][0] + grid[1][0];
        } else {
            int i = recursion(r - 1, c, grid, cache);
            int j = recursion(r, c - 1, grid, cache);
            cache[r][c] = grid[r][c] + Math.max(i, j);
        }
        return cache[r][c];
    }

    public static int backtrack(int[][] grid) {
        return backtrack(0, 0, grid);
    }

    private static int backtrack(int r, int c, int[][] grid) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 ) {
            return 0;
        }
        return grid[r][c] + Math.max(backtrack(r + 1, c, grid), backtrack(r, c + 1, grid));
    }

}