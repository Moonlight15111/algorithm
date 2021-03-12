package com.moonlight.algorithm.train.backtrack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/path-with-maximum-gold/
 *
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注
 * 每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *     每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 *     矿工每次可以从当前位置向上下左右四个方向走。
 *     每个单元格只能被开采（进入）一次。
 *     不得开采（进入）黄金数目为 0 的单元格。
 *     矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]    输出：24
 * 解释：
 *      [[0,6,0],
 *      [5,8,7],
 *      [0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 *
 * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]   输出：28
 * 解释：
 *   [[1,0,7],
 *   [2,0,6],
 *   [3,4,5],
 *   [0,3,0],
 *   [9,0,20]]
 * 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
 *
 * @author Moonlight
 * @date 2021/3/12 13:22
 */
public class PathWithMaximumGold {

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {0, 6, 0}, {5, 8, 7}, {0, 9, 0}
        }, b = new int[][] {
                {1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}
        };
        System.out.println(getMaximumGold(a));
        System.out.println(getMaximumGold(b));
    }

    public static int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0, rowMax = grid.length; i < rowMax; i++) {
            for (int j = 0, colMax = grid[i].length; j < colMax; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, backtrack(i, j, 0, grid));
                }
            }
        }
        return max;
    }

    private static int backtrack(int row, int col, int sum, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return sum;
        }
        int tmp = grid[row][col];
        sum += tmp;
        grid[row][col] = 0;
        int a = Math.max(backtrack(row + 1, col, sum, grid), backtrack(row - 1, col, sum, grid));
        int b = Math.max(backtrack(row, col + 1, sum, grid), backtrack(row, col - 1, sum, grid));
        grid[row][col] = tmp;
        return Math.max(a, b);
    }

}