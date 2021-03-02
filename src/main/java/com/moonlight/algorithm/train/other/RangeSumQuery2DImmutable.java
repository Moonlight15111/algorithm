package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * @author Moonlight
 * @date 2021/3/1 23:21
 */
public class RangeSumQuery2DImmutable {

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        arr[0] = new int[] {3, 0, 1, 4, 2};
        arr[1] = new int[] {5, 6, 3, 2, 1};
        arr[2] = new int[] {1, 2, 0, 1, 5};
        arr[3] = new int[] {4, 1, 0, 1, 7};
        arr[4] = new int[] {1, 0, 3, 0, 5};

        RangeSumQuery2DImmutable r = new RangeSumQuery2DImmutable(arr);
        // 8   11   12
        System.out.println(r.sumRegion(2, 1, 4, 3));
        System.out.println(r.sumRegion(1, 1, 2, 2));
        System.out.println(r.sumRegion(1, 2, 2, 4));
    }

    private int[][] sum;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        // 前缀和
        if (matrix.length > 0 && matrix[0].length > 0) {
            this.sum = new int[matrix.length][matrix[0].length];
            int[] tmp;
            for (int i = 0; i < matrix.length; i++) {
                tmp = new int[matrix[i].length];
                tmp[0] = matrix[i][0];
                for (int j = 1; j < matrix[i].length; j++) {
                    tmp[j] = tmp[j - 1] + matrix[i][j];
                }
                this.sum[i] = tmp;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null || row1 > sum.length ||  col1 > sum[0].length || row2 > sum.length || col2 > sum[0].length) {
            return 0;
        }
        int res = 0;

        for (int i = row1; i <= row2 ; i++) {
            res += (col1 > 0 ? sum[i][col2] - sum[i][col1 - 1] : sum[i][col2]);
        }

        return res;
    }

}
