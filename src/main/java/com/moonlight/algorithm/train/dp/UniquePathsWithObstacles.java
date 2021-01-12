package com.moonlight.algorithm.train.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/unique-paths-ii/
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * @author Moonlight
 * @date 2021/1/12 9:33
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] a = new int[3][3];
        a[0] = new int[]{0, 0, 0};
        a[1] = new int[]{0, 1, 0};
        a[2] = new int[]{0, 0, 0};

        int[][] b = new int[2][2];
        b[0] = new int[]{0, 1};
        b[1] = new int[]{0, 0};

        System.out.println(uniquePathsWithObstacles(a));
        System.out.println(uniquePathsWithObstacles22(a));

        System.out.println(uniquePathsWithObstacles(b));
        System.out.println(uniquePathsWithObstacles22(b));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        return process(obstacleGrid, 0, 0);
    }

    private static int process(int[][] obstacleGrid, int x, int y) {
        if (x == obstacleGrid[0].length - 1 && y < obstacleGrid.length - 1) {
            if (obstacleGrid[y][x] == 1) {
                return 0;
            }
            return process(obstacleGrid, x, y + 1);
        }
        if (y == obstacleGrid.length - 1 && x < obstacleGrid[0].length - 1) {
            if (obstacleGrid[y][x] == 1) {
                return 0;
            }
            return process(obstacleGrid, x + 1, y);
        }
        if (x == obstacleGrid[0].length - 1 && y == obstacleGrid.length - 1) {
            if (obstacleGrid[y][x] == 1) {
                return 0;
            }
            return 1;
        }
        if (obstacleGrid[y][x] == 1) {
            return 0;
        }
        return process(obstacleGrid, x + 1, y) + process(obstacleGrid, x, y + 1);
    }

    public static int uniquePathsWithObstacles22(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return process222(obstacleGrid, 0, 0, dp);
    }

    private static int process222(int[][] obstacleGrid, int x, int y, int[][] dp) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        if (x == obstacleGrid[0].length - 1 && y < obstacleGrid.length - 1) {
            dp[y][x] = obstacleGrid[y][x] == 1 ? 0 : process222(obstacleGrid, x, y + 1, dp);
            return dp[y][x];
        }
        if (y == obstacleGrid.length - 1 && x < obstacleGrid[0].length - 1) {
            dp[y][x] = obstacleGrid[y][x] == 1 ? 0 : process222(obstacleGrid, x + 1, y, dp);
            return dp[y][x];
        }
        if (x == obstacleGrid[0].length - 1 && y == obstacleGrid.length - 1) {
            dp[y][x] = obstacleGrid[y][x] == 1 ? 0 : 1;
            return dp[y][x];
        }
        if (obstacleGrid[y][x] == 1) {
            dp[y][x] = 0;
            return dp[y][x];
        }
        dp[y][x] = process222(obstacleGrid, x + 1, y, dp) + process222(obstacleGrid, x, y + 1, dp);
        return dp[y][x];
    }

}
