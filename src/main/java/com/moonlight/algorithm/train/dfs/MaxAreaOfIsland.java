package com.moonlight.algorithm.train.dfs;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/max-area-of-island/
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * 输入：                                 输出：6。岛屿只能包含水平或垂直的四个方向的 1 。
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * 输入: [[0,0,0,0,0,0,0,0]]       输出：0
 *
 * @author Moonlight
 * @date 2021/1/30 12:29
 */
public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    res = Math.max(process(grid, x, y), res);
                }
            }
        }
        return res;
    }

    public static int process(int[][] grid, int x, int y) {
        if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0) {
            if (grid[x][y] != 1) {
                return 0;
            }
            grid[x][y] = 0;

            return 1 + process(grid, x + 1, y) + process(grid, x - 1, y)
                    + process(grid, x, y + 1) + process(grid, x, y - 1);
        }
        return 0;
    }

}
