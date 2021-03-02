package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/01-matrix/
 * <p>
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。两个相邻元素间的距离为 1
 * <p>
 * 输入：           输入：
 * [[0,0,0],          [[0,0,0],
 * [0,1,0],            [0,1,0],
 * [0,0,0]]            [1,1,1]]
 * <p>
 * 输出：           输出：
 * [[0,0,0],          [[0,0,0],
 * [0,1,0],            [0,1,0],
 * [0,0,0]]            [1,2,1]]
 *
 * @author Moonlight
 * @date 2021/3/2 10:02
 */
public class UpdateMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0] = new int[]{1, 1, 1};
        arr[1] = new int[]{1, 0, 1};
        arr[2] = new int[]{1, 1, 1};

        int[][] ints = updateMatrix(arr);
        for (int[] a : ints) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {
        // 对于某一个位置 x, y 而言，距离它最近的0的距离有以下两种可能
        // 1.x,y == 1 => 1 + min((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))
        // 2.x,y == 0 => 0
        // 第二种情况不用考虑，只考虑第一种情况
        // 即x,y最近的0的位置，应该是在它上下左右四个方向之中最小的
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = matrix[i][j] == 1 ? 9999999 : 0;
            }
        }

        // 左上角
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0) {
                    res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                }
                if (j > 0) {
                    res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }
//        // 左下角
//        for (int i = row - 1; i >= 0; i--) {
//            for (int j = 0; j < col; j++) {
//                if (i < row - 1) {
//                    res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
//                }
//                if (j > 0) {
//                    res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
//                }
//            }
//        }
//        // 右上角
//        for (int i = 0; i < row; i++) {
//            for (int j = col - 1; j >= 0; j--) {
//                if (i > 0) {
//                    res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
//                }
//                if (j < col - 1) {
//                    res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
//                }
//            }
//        }
        // 右下角
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i < row - 1) {
                    res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                }
                if (j < col - 1) {
                    res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                }
            }
        }

        return res;
    }

}
