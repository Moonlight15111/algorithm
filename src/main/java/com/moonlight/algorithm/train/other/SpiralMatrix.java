package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/spiral-matrix/
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]   输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]   输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author Moonlight
 * @date 2021/3/15 13:06
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }, b = {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        }, c = {
                {2, 3}
        };
        System.out.println(spiralOrder(a));
        System.out.println(spiralOrder(b));
        System.out.println(spiralOrder(c));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int rowMax = matrix.length, colMax = matrix[0].length, left = 0, right = colMax - 1, top = 0, bottom = rowMax - 1, total = rowMax * colMax;

        while (total >= 1) {
            for (int i = left; i <= right && total >= 1; i++) {
                res.add(matrix[top][i]);
                total--;
            }
            top++;
            for (int i = top; i <= bottom && total >= 1; i++) {
                res.add(matrix[i][right]);
                total--;
            }
            right--;
            for (int i = right; i >= left && total >= 1; i--) {
                res.add(matrix[bottom][i]);
                total--;
            }
            bottom--;
            for (int i = bottom; i >= top && total >= 1; i--) {
                res.add(matrix[i][left]);
                total--;
            }
            left++;
        }

        return res;
    }

}
