package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/number-of-enclaves/
 *
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]  输出：3
 * 解释： 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 *
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]  输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 *
 * @author Moonlight
 */
public class NumEnclaves {

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}
        }, b = {
                {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}
        };

        System.out.println(numEnclaves(a));
        System.out.println(numEnclaves(b));
    }

    public static int numEnclaves(int[][] grid) {
        int ans = 0, r = grid.length, c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && (i == 0 || i == r - 1 || j == 0 || j == c - 1)) {
                    dfs(i, j, grid);
                }
            }
        }
        for (int[] ints : grid) {
            for (int i : ints) {
                if (i == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }

}