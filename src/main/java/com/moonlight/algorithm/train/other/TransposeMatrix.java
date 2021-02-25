package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 *
 * 原题：https://leetcode-cn.com/problems/transpose-matrix/
 *
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * @ClassName TransposeMatrix
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/25 22:12
 * @Version V1.0
 **/
public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] m = new int[2][3];
        m[0] = new int[] {1, 2, 3};
        m[1] = new int[] {4, 5, 6};

        m = transpose(m);

        for (int[] num : m) {
            System.out.println(Arrays.toString(num));
        }

        System.out.println();

        int[][] x = new int[3][3];
        x[0] = new int[] {1, 2, 3};
        x[1] = new int[] {4, 5, 6};
        x[2] = new int[] {7, 8, 9};

        x = transpose(x);

        for (int[] num : x) {
            System.out.println(Arrays.toString(num));
        }

    }

    public static int[][] transpose(int[][] matrix) {
        // 其实就是 m 行 n 列 转为 n 行 m 列
        // matrix[m][n] => matrix[n][m]
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

}
