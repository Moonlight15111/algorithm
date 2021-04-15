package com.moonlight.algorithm.train.backtrack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/island-perimeter/
 *
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 输入：grid = [[0,1,0,0],
 *               [1,1,1,0],
 *               [0,1,0,0],
 *               [1,1,0,0]]
 * 输出：16
 *
 * 输入：grid = [[1]]   输出：4
 *
 * 输入：grid = [[1,0]]  输出：4
 *
 * row == grid.length      col == grid[i].length
 * 1 <= row, col <= 100    grid[i][j] 为 0 或 1
 *
 * @author Moonlight
 * @date 2021/4/15 12:58
 */
public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] a = {
                {0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}
        }, b = {{1}}, c = {{1, 0}};
        System.out.println(islandPerimeter123132(a));
        System.out.println(islandPerimeter123132(b));
        System.out.println(islandPerimeter123132(c));
    }

    public static int islandPerimeter123132(int[][] grid) {
        int res = 0;

        for (int i = 0, row = grid.length, col = grid[0].length; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        res -=2;
                    }
                }
            }
        }

        return res;
    }

    public static int islandPerimeter(int[][] grid) {
        int res = 0;

        for (int i = 0, row = grid.length, col = grid[0].length; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res += search(i, j, grid);
                }
            }
        }

        return res;
    }

    private static int search(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int res = 4;
        if (i > 0) {
            if (grid[i - 1][j] == 1) {
                res--;
            }
        }
        if (i + 1 < grid.length) {
            if (grid[i + 1][j] == 1) {
                res--;
            }
        }
        if (j > 0) {
            if (grid[i][j - 1] == 1) {
                res--;
            }
        }
        if (j + 1 < grid[0].length) {
            if (grid[i][j + 1] == 1) {
                res--;
            }
        }
        return res;
    }

}
