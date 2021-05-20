package com.moonlight.algorithm.train.presum;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 *
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 * 输入：matrix = [[5,2],[1,6]], k = 1   输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 *
 * 输入：matrix = [[5,2],[1,6]], k = 2   输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 *
 * 输入：matrix = [[5,2],[1,6]], k = 3   输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 *
 * @author Moonlight
 * @date 2021/5/19 12:46
 */
public class KthLargestValue {

    public static void main(String[] args) {
        int[][] a = {
                {5, 2}, {1, 6}
        };
        System.out.println(kthLargestValue(a, 1));
        System.out.println(kthLargestValue(a, 2));
        System.out.println(kthLargestValue(a, 3));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        // 二维前缀和模板套出每个位置的值后，排序后，取第 K - 1 个
        int n = matrix.length, m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] ^ sum[i][j - 1] ^ sum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                list.add(sum[i][j]);
            }
        }
        list.sort((a, b) -> b - a);

        return list.get(k - 1);
    }

}
