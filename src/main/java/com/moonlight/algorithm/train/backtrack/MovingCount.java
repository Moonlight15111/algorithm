package com.moonlight.algorithm.train.backtrack;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 输入：m = 2, n = 3, k = 1  输出：3
 *
 * 输入：m = 3, n = 1, k = 0  输出：1
 *
 */
public class MovingCount {

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return backtrack(0, 0, m, n, k, visited);
    }

    private static int backtrack(int r, int c, int m, int n, int k, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || sum(r, c) > k) {
            return 0;
        }
        visited[r][c] = true;
        return 1 + backtrack(r + 1, c, m, n, k, visited) + backtrack(r, c + 1, m, n, k, visited);
    }

    private static int sum(int r, int c) {
        int ans = 0;
        while (r != 0) {
            ans += (r % 10);
            r /= 10;
        }
        while (c != 0) {
            ans += (c % 10);
            c /= 10;
        }
        return ans;
    }

}
