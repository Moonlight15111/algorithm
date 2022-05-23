package com.moonlight.algorithm.train.other;

/**
 * https://leetcode.cn/problems/score-after-flipping-matrix/
 *
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]] 输出：39
 * 解释：  转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 *        0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 * @author Moonlight
 */
public class MatrixScore {

    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        }));
    }

    public static int matrixScore(int[][] grid) {
        // 矩阵最大为 20 * 20，所以不用考虑溢出的问题
        // 那么想要考虑得分最高，则需要: 1. 每一行的首位都为 1  2. 每一列尽可能多的设置为 1
        //                      由上: 1. 对于行首为 0 的行，行翻转为 1
        //                            2. 统计每一列最多有多少个 1 并计算当前列这个 1 表示多大的数，累加到一起就是答案
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        for (int i = 0, cntOne; i < m; i++) {
            cntOne = 0;
            for (int[] g : grid) {
                cntOne += g[i];
            }
            ans += Math.max(cntOne, n - cntOne) * (1 << (m - i - 1));
        }
        return ans;
    }

}
