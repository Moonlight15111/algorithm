package com.moonlight.algorithm.train.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/rotting-oranges/
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *      值 0 代表空单元格；
 *      值 1 代表新鲜橘子；
 *      值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]  输出：4
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]  输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 输入：[[0,2]]  输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 */
public class OrangesRotting {

    public static void main(String[] args) {
        int[][] a = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }, b = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(orangesRotting(a));
        System.out.println(orangesRotting(b));
    }

    public static int orangesRotting(int[][] grid) {
        int ans = 0, fresh = 0, r = grid.length, c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (fresh > 0 && !q.isEmpty()) {
            ans++;
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int[] poll = q.poll();
                int x = poll[0], y = poll[1];

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    fresh--;
                    q.add(new int[]{x - 1, y});
                }
                if (x + 1 < r && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    fresh--;
                    q.add(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    fresh--;
                    q.add(new int[]{x, y - 1});
                }
                if (y + 1 < c && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    fresh--;
                    q.add(new int[]{x, y + 1});
                }
            }
        }

        return fresh > 0 ? -1 : ans;
    }


}