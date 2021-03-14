package com.moonlight.algorithm.train.backtrack;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * @ClassName NumIsLands
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/14 14:57
 * @Version V1.0
 **/
public class NumIsLands {

    public static void main(String[] args) {
        char[][] a = new char[][] {
                {'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0',}
        };
        System.out.println(numIslands(a));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0, rowMax = grid.length; i < rowMax; i++) {
            for (int j = 0, colMax = grid[i].length; j < colMax; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    backtrack(i, j, grid);
                }
            }
        }
        return res;
    }

    private static void backtrack(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';

        backtrack(row + 1, col, grid);
        backtrack(row - 1, col, grid);
        backtrack(row, col + 1, grid);
        backtrack(row, col - 1, grid);
    }


}
