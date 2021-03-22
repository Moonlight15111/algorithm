package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * @ClassName SearchMatrix
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/22 23:45
 * @Version V1.0
 **/
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(a, 3));
        System.out.println(searchMatrix(a, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, left = 0, right = (n * m) - 1, mid;
        // 二分 + 二维映射到一维
        while (left <= right) {
            mid = (right + left) >> 1;
            if (matrix[mid / m][mid % m] > target) {
                right = mid - 1;
            } else if (matrix[mid / m][mid % m] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
