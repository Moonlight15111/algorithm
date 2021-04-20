package com.moonlight.algorithm.train.backtrack;

/**
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 *
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]  输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 *
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]  输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * 输入：matrix = [[1]]  输出：1
 *
 * @ClassName LongestIncreasingPath
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/20 21:44
 * @Version V1.0
 **/
public class LongestIncreasingPath {

    public static void main(String[] args) {
        int[][] a = {
                {9, 9, 4}, {6, 6, 8}, {2, 1, 1}
        }, b = {
                {3, 4, 5}, {3, 2, 6}, {2, 2, 1}
        }, c = {
                {1}
        };
        System.out.println(longestIncreasingPath(a) + ", " + longestIncreasingPath123(a));
        System.out.println(longestIncreasingPath(b) + ", " + longestIncreasingPath123(b));
        System.out.println(longestIncreasingPath(c) + ", " + longestIncreasingPath123(c));
    }

    public static int longestIncreasingPath123(int[][] matrix) {
        int ans = 0, n = matrix.length, m = matrix[0].length;
        int[][] cache = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, process123(matrix, i, j, cache));
            }
        }
        return ans;
    }

    public static int process123(int[][] matrix, int i, int j, int[][] cache) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int up = i > 0 && matrix[i][j] < matrix[i - 1][j] ? process123(matrix, i - 1, j, cache) : 0;
        int down = i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j] ? process123(matrix, i + 1, j, cache) : 0;
        int left = j > 0 && matrix[i][j] < matrix[i][j - 1] ? process123(matrix, i, j - 1, cache) : 0;
        int right = j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1] ? process123(matrix, i, j + 1, cache) : 0;

        cache[i][j] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        return cache[i][j];
    }

    public static int longestIncreasingPath(int[][] matrix) {
        // timeout
        int ans = 0, n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, process(matrix, i, j));
            }
        }
        return ans;
    }

    public static int process(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        int up = i > 0 && matrix[i][j] < matrix[i - 1][j] ? process(matrix, i - 1, j) : 0;
        int down = i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j] ? process(matrix, i + 1, j) : 0;
        int left = j > 0 && matrix[i][j] < matrix[i][j - 1] ? process(matrix, i, j - 1) : 0;
        int right = j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1] ? process(matrix, i, j + 1) : 0;

        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    }

}
