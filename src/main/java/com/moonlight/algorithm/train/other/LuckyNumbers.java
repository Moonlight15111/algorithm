package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 *
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *   在同一行的所有元素中最小
 *   在同一列的所有元素中最大
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]  输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]  输出：[12]
 *
 * 输入：matrix = [[7,8],[1,2]]  输出：[7]
 *
 * @author Moonlight
 */
public class LuckyNumbers {

    public static void main(String[] args) {
        int[][] a = {
                {3, 7, 8}, {9, 11, 13}, {15, 16, 17}
        }, b = {
                {1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}
        }, c = {
                {7, 8}, {1, 2}
        };
        System.out.println(luckyNumbers(a));
        System.out.println(luckyNumbers(b));
        System.out.println(luckyNumbers(c));
    }


    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int c = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < c; j++) {
                boolean min = true, max = true;
                for (int k = 0; k < c; k++) {
                    if (ints[k] < ints[j]) {
                        min = false;
                        break;
                    }
                }
                if (!min) {
                    continue;
                }
                for (int[] value : matrix) {
                    if (value[j] > ints[j]) {
                        max = false;
                        break;
                    }
                }
                if (max) {
                    ans.add(ints[j]);
                }
            }
        }
        return ans;
    }

}