package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8  输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 *
 * 输入：matrix = [[-5]], k = 1  输出：-5
 *
 * @ClassName KthSmallest
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/23 14:03
 * @Version V1.0
 **/
public class KthSmallest {

    public static void main(String[] args) {
        int[][] a = {
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        };
        System.out.println(sort(a, 8));
    }

    public static int sort(int[][] matrix, int k) {
        int r = matrix.length, c = matrix[0].length, i = 0;
        int[] a = new int[r * c];
        for (int[] m : matrix) {
            for (int n : m) {
                a[i++] = n;
            }
        }
        Arrays.sort(a);
        return a[k - 1];
    }

}
