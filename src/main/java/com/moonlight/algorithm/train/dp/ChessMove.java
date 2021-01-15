package com.moonlight.algorithm.train.dp;

/**
 * 10行9列的中国象棋，给定一个坐标点(x,y)，求棋子马移动K步后到达坐标点(x,y)的方法有多少种
 * @ClassName ChessMove
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/15 21:03
 * @Version V1.0
 **/
public class ChessMove {


    public static void main(String[] args) {
        System.out.println(chessMove(2, 3, 3));
        System.out.println(dp(2, 3, 3));
    }

    public static int chessMove(int x, int y, int k) {
        return process(x, y, k);
    }

    public static int process(int x, int y, int k) {
        if (k == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        if (y < 0 || x < 0 || x > 9 || y > 8) {
            return 0;
        }
        return process(x + 2, y - 1, k - 1) + process(x + 2, y + 1, k - 1) + process(x + 1, y + 2, k - 1)
               + process(x - 1, y + 2, k - 1) + process(x - 2, y + 1, k - 1) + process(x - 2, y - 1, k - 1)
                + process(x - 1, y - 2, k - 1) + process(x + 1, y - 2, k - 1);
    }

    public static int dp(int x, int y, int k) {
        int[][][] dp = new int[10][9][k + 1];
        dp[0][0][0] = 1;

        for (int kk = 1; kk <= k; kk++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    dp[i][j][kk] = getDpCache(dp, i + 2, j - 1, kk - 1) + getDpCache(dp, i + 2, j + 1, kk - 1) + getDpCache(dp, i + 1, j + 2, kk - 1)
                            + getDpCache(dp, i - 1, j + 2, kk - 1) + getDpCache(dp, i - 2, j + 1, kk - 1) + getDpCache(dp, i - 2, j - 1, kk - 1)
                            + getDpCache(dp, i - 1, j - 2, kk - 1) + getDpCache(dp, i + 1, j - 2, kk - 1);
                }
            }
        }

        return dp[x][y][k];
    }

    private static int getDpCache(int[][][] dp, int x, int y, int k) {
        if (y < 0 || x < 0 || x > 9 || y > 8) {
            return 0;
        }
        return dp[x][y][k];
    }

}
