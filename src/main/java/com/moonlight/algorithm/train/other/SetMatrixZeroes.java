package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 进阶：
 *     一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 *     一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 *     你能想出一个仅使用常量空间的解决方案吗？
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * @ClassName SetMatrixZeroes
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/21 12:55
 * @Version V1.0
 **/
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 1}, {1, 0, 1}, {1, 1, 1}
        }, b = {
                {0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}
        };

//        setZeroes(a);
        setZeroes123121(a);
        for (int[] arr : a) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("================================");

//        setZeroes(b);
        setZeroes123121(b);
        for (int[] arr : b) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void setZeroes123121(int[][] matrix) {
        int rowMax = matrix.length, colMax = matrix[0].length;
        boolean[] visitedRow = new boolean[rowMax];
        boolean[] visitedCol = new boolean[colMax];

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (matrix[i][j] == 0) {
                    visitedRow[i] = true;
                    visitedCol[j] = true;
                }
            }
        }
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (visitedRow[i] || visitedCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0, rowMax = matrix.length; i < rowMax; i++) {
            for (int j = 0, colMax = matrix[i].length; j < colMax; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    for (int top = i - 1; top >= 0; top--) {
                        if (matrix[top][j] == 0 && !visited[top][j]) {
                            break;
                        }
                        matrix[top][j] = 0;
                        visited[top][j] = true;
                    }
                    for (int bottom = i + 1; bottom < rowMax; bottom++) {
                        if (matrix[bottom][j] == 0 && !visited[bottom][j]) {
                            break;
                        }
                        matrix[bottom][j] = 0;
                        visited[bottom][j] = true;
                    }
                    for (int left = j - 1; left >= 0; left--) {
                        if (matrix[i][left] == 0 && !visited[i][left]) {
                            break;
                        }
                        matrix[i][left] = 0;
                        visited[i][left] = true;
                    }
                    for (int right = j + 1; right < colMax; right++) {
                        if (matrix[i][right] == 0 && !visited[i][right]) {
                            break;
                        }
                        matrix[i][right] = 0;
                        visited[i][right] = true;
                    }
                }
            }
        }
    }

}
