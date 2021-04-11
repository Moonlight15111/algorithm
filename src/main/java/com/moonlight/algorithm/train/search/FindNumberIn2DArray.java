package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 矩阵: [
 *         [1,   4,  7, 11, 15],
 *         [2,   5,  8, 12, 19],
 *         [3,   6,  9, 16, 22],
 *         [10, 13, 14, 17, 24],
 *         [18, 21, 23, 26, 30]
 *       ]
 * 输入：target = 5
 * 输出: true
 *
 * 输入：target = 20
 * 输出: false
 *
 * @ClassName FindNumberIn2DArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/11 16:12
 * @Version V1.0
 **/
public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] a = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(a, 5));
        System.out.println(findNumberIn2DArray(a, 20));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1, num;
        while (i < m && j >= 0) {
            num = matrix[i][j];
            if (num > target) {
                j--;
            } else if (num < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

}
