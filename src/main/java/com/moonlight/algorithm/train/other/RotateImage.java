package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]    输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 输入：matrix = [[1]]  输出：[[1]]
 *
 * @author Moonlight
 * @date 2021/3/22 10:01
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }, b = {
                {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
        }, c = {
                {1}
        };
        rotate(a);
        rotate(b);
        rotate(c);

        for (int[] arr : a) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("=================================");
        for (int[] arr : b) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("=================================");
        for (int[] arr : c) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void rotate(int[][] matrix) {
        // 不用辅助数组的暂时还写不出来，有点想不明白
        int n = matrix.length, m = matrix[0].length;
        int[][] help = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                help[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(help[i], 0, matrix[i], 0, m);
        }
    }

}
