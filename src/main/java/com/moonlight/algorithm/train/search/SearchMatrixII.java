package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *   每行的元素从左到右升序排列。
 *   每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 * @author Moonlight
 */
public class SearchMatrixII {

    public static void main(String[] args) {
        int[][] a = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, b = {
                {1, 1}
        }, c = {
                {5, 6}
        };
        System.out.println(searchMatrix(a, 5));
        System.out.println(searchMatrix(a, 20));
        System.out.println(searchMatrix(b, 2));
        System.out.println(searchMatrix(c, 6));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1, m;
        while (r < row && c >= 0) {
            m = matrix[r][c];
            if (m > target) {
                c--;
            } else if (m < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }

}