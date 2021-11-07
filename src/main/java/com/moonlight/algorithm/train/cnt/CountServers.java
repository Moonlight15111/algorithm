package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/count-servers-that-communicate/
 *
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 * 输入：grid = [[1,0],[0,1]]  输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 *
 * 输入：grid = [[1,0],[1,1]] 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 *
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]  输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 *
 * @author Moonlight
 */
public class CountServers {

    public static void main(String[] args) {
        int[][] a = {
                {1, 0}, {0, 1}
        }, b = {
                {1, 0}, {1, 1}
        }, c = {
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        System.out.println(countServers(a));
        System.out.println(countServers(b));
        System.out.println(countServers(c));
    }

    public static int countServers(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[] rows = new int[r], cols = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

}