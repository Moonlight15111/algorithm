package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/count-sub-islands/
 *
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。
 * 一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，
 * 也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，
 * 那么我们称 grid2 中的这个岛屿为 子岛屿 。
 * 请你返回 grid2 中 子岛屿 的 数目 。
 *
 * 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]],
 *      grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * 输出：3
 *
 * 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]],
 *      grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * 输出：2
 *
 * @ClassName CountSubIslands
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/12/12 11:42
 * @Version V1.0
 **/
public class CountSubIslands {

    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}
        }, b = {
                {1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}
        }, c = {
                {1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}
        }, d = {
                {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}
        };
        System.out.println(countSubIslands(a, b));
        System.out.println(countSubIslands(c, d));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    ans += dfs(grid1, grid2, i, j) ? 1 : 0;
                }
            }
        }
        return ans;
    }

    private static boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {
        if (r < 0 || c < 0 || r >= grid1.length || c >= grid1[0].length || grid2[r][c] != 1) {
            return true;
        }

        grid2[r][c] = -1;
        boolean left = dfs(grid1, grid2, r + 1, c);
        boolean right = dfs(grid1, grid2, r - 1, c);
        boolean bot = dfs(grid1, grid2, r, c + 1);
        boolean top = dfs(grid1, grid2, r, c - 1);

        return grid1[r][c] == 1 && left && right && bot && top;
    }

}
