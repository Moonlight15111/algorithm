package com.moonlight.algorithm.train.dp;

import java.util.*;
/**
 * 原题：https://leetcode-cn.com/problems/robot-in-a-grid-lcci/
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，
 * 但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 *
 * @ClassName PathWithObstacles
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/10 11:49
 * @Version V1.0
 **/
public class PathWithObstacles {

    public static void main(String[] args) {
        int[][] a = new int[3][3];
        a[0] = new int[]{0, 0, 0};
        a[1] = new int[]{0, 1, 0};
        a[2] = new int[]{0, 0, 0};
        for (List<Integer> list : pathWithObstacles(a)) {
            for (int aa : list) {
                System.out.print(aa + ",");
            }
            System.out.println();
        }

        int[][] b = new int[1][2];
        b[0] = new int[]{0, 0};
        for (List<Integer> list : pathWithObstacles(b)) {
            for (int aa : list) {
                System.out.print(aa + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return res;
        }

        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        res.add(start);
        if (process(obstacleGrid, 0, 0, res)) {
            return res;
        }

        return new ArrayList<>();
    }

    private static boolean process(int[][] obstacleGrid, int x, int y, List<List<Integer>> res) {
        if (x >= obstacleGrid[0].length || y >= obstacleGrid.length || obstacleGrid[y][x] == 1) {
            return false;
        }
        if (x == obstacleGrid[0].length - 1 && y == obstacleGrid.length - 1) {
            return true;
        }
        List<Integer> right = new ArrayList<>();
        right.add(y);
        right.add(x + 1);
        res.add(right);
        if (process(obstacleGrid, x + 1, y, res)) {
            return true;
        }
        res.remove(res.size() - 1);

        List<Integer> down = new ArrayList<>();
        down.add(y + 1);
        down.add(x);
        res.add(down);
        if (process(obstacleGrid, x, y + 1, res)) {
            return true;
        }
        res.remove(res.size() - 1);

//        obstacleGrid[y][x] = 1;

        return false;
    }


}
