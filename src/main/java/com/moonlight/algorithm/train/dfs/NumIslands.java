package com.moonlight.algorithm.train.dfs;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 原题：https://leetcode-cn.com/problems/number-of-islands
 *
 * 输入：grid = [           输出：1
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 *
 *
 * 输入：grid = [            输出：3
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 *
 *
 * @author Moonlight
 * @date 2021/1/30 10:58
 */
public class NumIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 对于任意一个不出界的位置 i(x, y)，如果它本身是 '1'，那么起码可以判定它是一个岛了
        // 接下来就是需要去它临近的四个方位进行搜索，找出连续的岛
        int res = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    res++;
                    process(grid, x, y);
                }
            }
        }
        return res;
    }

    private static void process(char[][] grid, int x, int y) {
        if (x < grid.length && y < grid[0].length && x >= 0 && y >= 0) {
            if (grid[x][y] != '1') {
                return ;
            }

            grid[x][y] = '0';

            process(grid, x - 1, y);
            process(grid, x + 1, y);
            process(grid, x, y - 1);
            process(grid, x, y + 1);
        }
    }

}
