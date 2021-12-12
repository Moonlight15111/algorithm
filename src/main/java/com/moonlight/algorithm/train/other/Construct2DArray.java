package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/convert-1d-array-into-2d-array/
 *
 * 给你一个下标从 0 开始的一维整数数组 original 和两个整数 m 和  n 。你需要使用 original 中 所有 元素创建一个 m 行 n 列的二维数组。
 * original 中下标从 0 到 n - 1 （都 包含 ）的元素构成二维数组的第一行，下标从 n 到 2 * n - 1 （都 包含 ）的元素构成二维数组的第二行，依此类推。
 * 请你根据上述过程返回一个 m x n 的二维数组。如果无法构成这样的二维数组，请你返回一个空的二维数组。
 *
 * 输入：original = [1,2,3,4], m = 2, n = 2  输出：[[1,2],[3,4]]
 *
 * 输入：original = [1,2,3], m = 1, n = 3  输出：[[1,2,3]]
 *
 * 输入：original = [1,2], m = 1, n = 1  输出：[]
 *
 * 输入：original = [3], m = 1, n = 2  输出：[]
 *
 * @ClassName Construct2DArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/12/12 11:31
 * @Version V1.0
 **/
public class Construct2DArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4}, b = {1, 2, 3}, c = {1, 2}, d = {3};

        int[][] ints = construct2DArray(a, 2, 2);
        for (int[] i : ints) {
            System.out.print(Arrays.toString(i) + ", ");
        }
        System.out.println();

        ints = construct2DArray(b, 1, 3);
        for (int[] i : ints) {
            System.out.print(Arrays.toString(i) + ", ");
        }
        System.out.println();

        ints = construct2DArray(c, 1, 1);
        for (int[] i : ints) {
            System.out.print(Arrays.toString(i) + ", ");
        }
        System.out.println();

        ints = construct2DArray(d, 1, 2);
        for (int[] i : ints) {
            System.out.print(Arrays.toString(i) + ", ");
        }
        System.out.println();
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (len != (m * n)) {
            return new int[0][0];
        }
        int[][] ans = new int[m][n];
        for (int i = 0, k = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[k++];
            }
        }
        return ans;
    }

}
