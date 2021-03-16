package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 输入：n = 3   输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 输入：n = 1   输出：[[1]]
 *
 * @author Moonlight
 * @date 2021/3/16 9:16
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for (int[] a : ints) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][];
        }
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, num = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = num++;
            }
            for (int i = right - 1; i > left; i--) {
                res[bottom][i] = num++;
            }
            for (int i = bottom; i > top ; i--) {
                res[i][left] = num++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return res;
    }

}
