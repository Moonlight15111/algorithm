package com.moonlight.algorithm.train.dfs;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 *
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2  输出：2
 * 解释：矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 *
 * 输入：matrix = [[2,2,-1]], k = 3   输出：3
 *
 * @author Moonlight
 * @date 2021/4/22 12:51
 */
public class MaxSumSubmatrix {

    public static void main(String[] args) {
        int[][] a = {
                {1, 0, 1}, {0, -2, 3}
        }, b = {
                {2, 2, -1}
        };
        System.out.println(maxSumSubmatrix(a, 2));
        System.out.println(maxSumSubmatrix(b, 0));
    }

    /*  二维数组前缀和:
          二维前缀和数组中的每一个格子记录的是 以当前位置为区域的右下角（区域左上角恒定为原数组的左上角）的区域和
          解决的是二维矩阵中的矩形区域求和问题。
          模板:
              // 预处理前缀和数组
             {
                sum = new int[n + 1][m + 1];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        // 当前格子(和) = 上方的格子(和) + 左边的格子(和) - 左上角的格子(和) + 当前格子(值)【和是指对应的前缀和，值是指原数组中的值】
                        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                    }
                }
            }
           求某一段区域和 [i, j] 的模板是 sum[x][y] - sum[i - 1][y] + sum[x][j - 1] + sum[i - 1][j - 1]
           for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int x = i; x <= n; x++) {
                    for (int y = j; y <= m; y++) {
                        int s = sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1];
                        if (s <= k) {
                            ans = Math.max(ans, s);
                        }
                    }
                }
            }
        }
     *
     *
     */

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        // 二维前缀和数组模板
        int n = matrix.length, m = matrix[0].length, ans = Integer.MIN_VALUE;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int x = i; x <= n; x++) {
                    for (int y = j; y <= m; y++) {
                        int s = sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1];
                        if (s <= k) {
                            ans = Math.max(ans, s);
                        }
                    }
                }
            }
        }

        return ans;
    }

}
