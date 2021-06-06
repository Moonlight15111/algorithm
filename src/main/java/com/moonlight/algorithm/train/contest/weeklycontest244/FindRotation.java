package com.moonlight.algorithm.train.contest.weeklycontest244;

import java.util.Arrays;

/**
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，
 * 如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 *
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 *
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 *
 * @ClassName FindRotation
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/6 10:36
 * @Version V1.0
 **/
public class FindRotation {

    public static void main(String[] args) {
        int[][] a = {
                {0, 1}, {1, 0}
        }, b = {
                {1, 0}, {0, 1}
        }, c = {
                {0, 1}, {1, 1}
        }, d = {
                {1, 0}, {0, 1}
        }, e = {
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        }, f = {
                {1, 1, 1}, {0, 1, 0}, {0, 0, 0}
        }, g = {
                {1, 0, 1}, {0, 0, 0}, {1, 0, 0}
        }, h = {
                {0, 0, 0}, {1, 1, 1}, {0, 0, 0}
        };
        System.out.println(findRotation(a, b));
        System.out.println(findRotation(c, d));
        System.out.println(findRotation(e, f));
        System.out.println(findRotation(g, h));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length, m = mat[0].length;
        if (n != target.length || m != target[0].length) {
            return false;
        }
        if (Arrays.deepEquals(mat, target)) {
            return true;
        }
        int[][] rotation = rotation(mat, n, m);
        if (Arrays.deepEquals(rotation, target)) {
            return true;
        }
        if (Arrays.deepEquals(rotation(rotation, n, m), target)) {
            return true;
        }
        return Arrays.deepEquals(rotation(rotation(rotation, n, m), n, m), target);
    }

    public static int[][] rotation(int[][] mat, int n, int m) {
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][n - i - 1] = mat[i][j];
            }
        }
        return res;
    }

}
