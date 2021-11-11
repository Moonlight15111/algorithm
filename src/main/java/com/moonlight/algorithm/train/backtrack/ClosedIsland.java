package com.moonlight.algorithm.train.backtrack;

/**
 * https://leetcode-cn.com/problems/number-of-closed-islands/
 * <p>
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * 请返回封闭岛屿的数目。
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]  输出：1
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 *
 * @author Moonlight
 */
public class ClosedIsland {

    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        }, b = {
                {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}
        }, c = {
                {1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1}
        };
        System.out.println(closedIsland(a));
        System.out.println(closedIsland(b));
        System.out.println(closedIsland(c));
    }

    public static int closedIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && backtrack(i, j, grid)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean backtrack(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return false;
        }
        if (grid[r][c] != 0) {
            return true;
        }
        grid[r][c] = -1;

        boolean left = backtrack(r - 1, c, grid);
        boolean right = backtrack(r + 1, c, grid);
        boolean bot = backtrack(r, c - 1, grid);
        boolean top = backtrack(r, c + 1, grid);

        return left && right && bot && top;
    }

}
